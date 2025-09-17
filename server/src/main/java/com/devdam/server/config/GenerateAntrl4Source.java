package com.devdam.server.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GenerateAntrl4Source {
    private static final String packageName = "com/z_antlr/generated";
    private static final String outputDirectory = "src/main/java/" + packageName;
    private static final String antlr4FileBasePath = "src/main/antlr4/com/antlr/code/";
    private static final Path currentDirectory = Paths.get(System.getProperty("user.dir"));

    private static String grammarFilePath, outputDirPath;

    // Run the source generator
    public static void main(String[] args) {
        GenerateAntrl4Source worker = new GenerateAntrl4Source();

        try {
            worker.start();
        }
        catch (IOException e) {
            log.error("Generation Error [IOException]: {}", e.getMessage());
        }
        catch (InterruptedException e) {
            log.error("Generation Error [InterruptedException]: {}", e.getMessage());
        }
    }

    // Start the worker
    public void start() throws IOException, InterruptedException {
        // build dir if not exist
        buildDir();

        // Generate antlr4 source files to use for project...
        generate();

        // Programmatically adding the package name to the generated files
        updateGeneratedFiles();
    }

    // Building dir to store generated files
    public void buildDir(){
        // Ensure the output directory exists
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists()) outputDir.mkdirs();

        // Execute command from the project directory
        grammarFilePath = currentDirectory.resolve(antlr4FileBasePath).toString() + File.separator;
        outputDirPath = currentDirectory.resolve(outputDirectory).toString() + File.separator;
    }

    // Generate method that is running sub process to generate the files
    private void generate() throws IOException, InterruptedException {
        // Update grammar file path string to include the filename
        grammarFilePath = grammarFilePath + File.separator + "Lazer.g4";

        log.info("Preparing to generate antlr4 source files...");

        // Use Maven to run ANTLR4 with proper classpath and dependencies
        String mavenCommand = String.format(
            "mvn exec:java -Dexec.mainClass=\"org.antlr.v4.Tool\" -Dexec.args=\"-listener -visitor -o %s %s\"", 
            outputDirPath, grammarFilePath
        );

        // Create a process builder to run the command - OS agnostic
        ProcessBuilder processBuilder;
        String osName = System.getProperty("os.name").toLowerCase();
        
        if (osName.contains("win")) {
            // Windows
            processBuilder = new ProcessBuilder("cmd.exe", "/c", mavenCommand);
        } else {
            // Linux/Unix/Mac
            processBuilder = new ProcessBuilder("sh", "-c", mavenCommand);
        }

        // Set the working directory to the project root (where pom.xml is)
        processBuilder.directory(currentDirectory.toFile());

        log.info("Generating source files using Maven...");

        // Start the process
        Process process = processBuilder.start();

        // Read the output from the process
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // Read the error stream from the process
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.err.println(line);
            }
        }

        // Wait for the process to finish and get the exit code
        int exitCode = process.waitFor();

        // Print exit code
        if(exitCode == 0){
            log.info("Antlr4 source files generated successfully!");
        }
        else{
            log.info("Antlr4 file generation failed!");
        }
    }

    /* UTILITY METHODS */
    // This method will be adding the package name to the generated files
    public static void updateGeneratedFiles(){
        String directory = outputDirPath; // "/path/to/your/java/files";
        String pckName = packageName.replace("/", "."); // "com.yourpackage.name";

        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            List<Path> javaFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .toList();

            for (Path javaFile : javaFiles) {
                addPackageIfMissing(javaFile, pckName);
            }

            System.out.println("\n");
            log.info("Package name '{}", pckName + "' was place inside the generated Antlr4 source files successfully!");
        }
        catch (IOException e) {
            log.error("There was an error updating the generated Antlr4 source files: {}", e.getMessage());
        }
    }

    // This method will add the package name to each generated java files if missing
    private static void addPackageIfMissing(Path javaFile, String packageName) {
        try {
            List<String> lines = Files.readAllLines(javaFile);

            if (lines.isEmpty() || !lines.get(0).startsWith("package ")) {
                System.out.println("Adding package name to file: " + javaFile.getFileName());

                lines.add(0, "package " + packageName + ";\n\n");
                Files.write(javaFile, lines);
            }
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

