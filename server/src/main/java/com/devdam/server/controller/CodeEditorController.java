package com.devdam.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdam.server.error.LazerSyntaxErrorException;
import com.devdam.server.service.EngineServiceImpl;
import com.github.javafaker.Faker;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CodeEditorController {
    //private final ApplicationProperties applicationProperties;
    private final EngineServiceImpl engineService;

    @PostMapping({"/run-code/", "/run-code"})
    public ResponseEntity<Map<String, String>> run(@RequestBody Map<String, String> body, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        Boolean busy = (Boolean) session.getAttribute("code-executing");

        if(busy == null) response.put("noExecution", "You are not allowed to do that here!");
        else if(busy) response.put("busy", "I'm busy executing your code, please wait...");
        else{
            session.setAttribute("code-executing", true);

            // if not busy
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignore) {}

            try {
                String[] results = engineService.executeCode(body.get("code"));
                String executionSteps = ">>>>> Steps <<<<<" + results[1] + "\n\n>>>>> Results <<<<<";

                response.put("result", results[0]);
                response.put("steps", executionSteps);

                session.setAttribute("execution-results", results[0]);
            }
            catch (LazerSyntaxErrorException e) {
                String errors = e.getMultipleErrors().replace("[", "").replace("]", "").replaceAll(", ", "\n");

                response.put("syntaxError", errors);
            }
            catch (Exception e) {
                response.put("engineError", "Engine Error: " + e.getMessage());
            }

            session.setAttribute("code-executing", false);
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping({"/ai-explanation/", "/ai-explanation"})
    public ResponseEntity<String> explain(@RequestBody Map<String, String> body, HttpSession session){
        String code = body.get("code");

        // If code was not sent then throw a custom error
        if(code == null) {
            return ResponseEntity.ok().body("Sorry, I cannot explain a blank expression!");
        }

        String response;

        // This is where the program will get a response the AI explaining what is happening in the execution.
        try {
            String resultFromCodeExecution = (String) session.getAttribute("execution-results");

            response = engineService.promptAI(code.trim(), resultFromCodeExecution);

            /*// If no response was returned
            if(response == null) {
                response = "I'm sorry for the inconvenience, but I cannot explain this impure " +
                        "lambda calculus expression at this time. Please try another expression " +
                        "for now, thanks!";
            }*/

            // If no response was returned
            if(response == null) {
                response = engineService.promptAI(code.trim().trim(), resultFromCodeExecution);

                if(response == null) {
                    response = "I'm sorry for the inconvenience, but I cannot explain this impure " +
                            "lambda calculus expression at this time. Please try another expression " +
                            "for now, thanks!";
                }
            }
        }
        catch (Exception e) {
            response = "AI Explanation Error: " + e.getMessage();
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping({"/test-ai/", "/test-ai"})
    public ResponseEntity<List<String>> explainTest(@RequestBody Map<String, String> body){
        List<String> words = new ArrayList<>();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignore) {}

        Faker faker = new Faker();
        words = faker.lorem().words(500);

        return ResponseEntity.ok().body(words);
    }
}