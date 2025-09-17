package com.devdam.server.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.devdam.server.util.BaseUtils;
import com.devdam.server.util.JarUtils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Profile("dev")
@Component
@Slf4j
public class AutoJarBuilder implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        generateJarFile();
    }

    // This method will be automatically building a jar
    private void generateJarFile(){
        if(JarUtils.isJarConfigSet()) return;

        Thread thread = new Thread(() -> {
            try {
                log.info("Preparing to build jar file...");

                Thread.sleep(5000);

                // Get the current project directory
                Path currentDirectory = Paths.get(System.getProperty("user.dir"));

                // Full path to the mvnw script in the current project directory
                String mvnwPath = currentDirectory.resolve("mvnw").toString();

                // Command to run Maven package
                String command = (BaseUtils.isWindowsOS() ? "cmd.exe /C " : "sh -c ") + mvnwPath + " clean package -DskipTests";

                // Execute command from the project directory
                ProcessBuilder builder = new ProcessBuilder(command.split(" "));
                builder.directory(currentDirectory.toFile());

                log.info("Building jar file...");

                // Start the process
                Process process = builder.start();

                // Wait for the process to finish and get the exit code
                int exitCode = process.waitFor();

                // Print exit code
                if(exitCode == 0){
                    log.info("Jar file generated successfully!");
                    JarUtils.setJarConfig(true);
                }
                else{
                    log.info("Jar file generation failed!");
                    JarUtils.setJarConfig(false);
                }
            }
            catch (IOException | InterruptedException e) {
                log.error("Error building jar file: " + e.getMessage());

                JarUtils.setJarConfig(false);
            }
        });

        thread.setName("building-jar");
        thread.start();
    }
}
