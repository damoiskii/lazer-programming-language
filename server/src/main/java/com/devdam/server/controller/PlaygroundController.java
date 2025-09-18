package com.devdam.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devdam.server.dto.PlaygroundExecutionRequest;
import com.devdam.server.dto.PlaygroundExecutionResponse;
import com.devdam.server.error.LazerSyntaxErrorException;
import com.devdam.server.service.EngineServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playground")
@Slf4j
public class PlaygroundController {
    private final EngineServiceImpl engineService;
    
    @PostMapping("/execute")
    public ResponseEntity<PlaygroundExecutionResponse> executeCode(@RequestBody PlaygroundExecutionRequest request) {
        String code = request.getCode();
        
        // Validate input
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.badRequest()
                .body(PlaygroundExecutionResponse.error("Please enter some code to execute"));
        }
        
        // Apply safeguard: ensure code uses # notation instead of λ
        String sanitizedCode = code.replace("λ", "#");
        
        try {
            log.info("Executing Lazer code: {}", sanitizedCode);
            
            // Execute the code
            String[] results = engineService.executeCode(sanitizedCode);
            String executionResult = results[0];
            String executionSteps = results[1];
 
            log.info("Execution steps: {}", executionSteps);
            log.info("Execution result: {}", executionResult);
            
            // Get AI explanation
            String explanation;
            try {
                explanation = engineService.promptAI(sanitizedCode, executionResult);
                if (explanation == null || explanation.trim().isEmpty()) {
                    log.warn("AI returned empty explanation, using fallback");
                    explanation = generateFallbackExplanation(sanitizedCode, executionResult);
                }
            } catch (Exception e) {
                log.warn("AI explanation failed, using fallback: {}", e.getMessage());
                explanation = generateFallbackExplanation(sanitizedCode, executionResult);
            }
            
            return ResponseEntity.ok(
                PlaygroundExecutionResponse.success(executionResult, explanation, executionSteps)
            );
            
        } catch (LazerSyntaxErrorException e) {
            String errors = e.getMultipleErrors()
                .replace("[", "")
                .replace("]", "")
                .replaceAll(", ", "\n");
            
            return ResponseEntity.badRequest()
                .body(PlaygroundExecutionResponse.error("Syntax Error: " + errors));
                
        } catch (Exception e) {
            log.error("Execution error: ", e);
            return ResponseEntity.internalServerError()
                .body(PlaygroundExecutionResponse.error("Execution error: " + e.getMessage()));
        }
    }
    
    /**
     * Generate a fallback explanation when AI is not available
     */
    private String generateFallbackExplanation(String code, String result) {
        StringBuilder explanation = new StringBuilder();
        
        explanation.append("Lambda expression analysis:\n\n");
        
        // Basic pattern matching for common expressions
        if (code.matches("#\\s*\\w+\\s*\\.\\s*\\w+")) {
            explanation.append("This is the identity function pattern. ");
            explanation.append("It takes one parameter and returns it unchanged. ");
            explanation.append("This is one of the fundamental building blocks in lambda calculus.");
        } else if (code.contains("#f.#x.x")) {
            explanation.append("This represents the Church numeral for zero. ");
            explanation.append("It takes two parameters: a function (f) and a value (x), ");
            explanation.append("but applies the function zero times to the value, returning just x.");
        } else if (code.contains("#f.#x.f x")) {
            explanation.append("This represents the Church numeral for one. ");
            explanation.append("It takes a function (f) and a value (x), ");
            explanation.append("and applies the function once to the value.");
        } else if (code.contains("#x.#y.x")) {
            explanation.append("This is the constant function. ");
            explanation.append("It takes two parameters but always returns the first one, ");
            explanation.append("ignoring the second parameter completely.");
        } else {
            explanation.append("This lambda expression follows proper Lazer syntax using # notation ");
            explanation.append("for lambda abstractions. The expression defines a function that ");
            explanation.append("can be applied to arguments following lambda calculus evaluation rules.");
        }
        
        explanation.append("\n\nResult: ").append(result);
        explanation.append("\n\nThe expression has been successfully parsed and evaluated ");
        explanation.append("according to impure lambda calculus semantics.");
        
        return explanation.toString();
    }
}