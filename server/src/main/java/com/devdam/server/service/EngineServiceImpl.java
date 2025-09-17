package com.devdam.server.service;

import com.devdam.server.antlr4.CustomErrorListener;
import com.devdam.server.antlr4.LazerWalker;
import com.devdam.server.config.properties.NovitaProperties;
import com.devdam.server.error.LazerSyntaxErrorException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.z_antlr.generated.LazerLexer;
import com.z_antlr.generated.LazerParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {
    private final NovitaProperties novitaProperties;
    private StringBuilder stepsToNF;

    @Override
    public String[] executeCode(String code) throws LazerSyntaxErrorException {
        stepsToNF = new StringBuilder();

        // Converting the code (string) to the proper input stream for the lexer
        CodePointCharStream input = CharStreams.fromString(code);

        // Recording the steps here...
        stepsToNF.append("~ Lazer is now performing the lexical analysis [tokenizing source code].\n");

        // Sending the code here to the lexer
        LazerLexer lexer = new LazerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();

        StringBuilder sb = new StringBuilder();

        for(Token token : tokens.getTokens()){
            sb.append(lexer.getVocabulary().getSymbolicName(token.getType())).append(": ").append(token.getText()).append(",  ");
        }

        // Recording the steps here...
        stepsToNF.append("?Tokens returned from the lexer: [").append(sb.toString().replace("EOF,  ", "EOF").replace("<EOF>,  ", "<EOF>")).append("].");

        // Sending the tokenized code to the parser
        LazerParser parser = new LazerParser(tokens);
        //ParseTree tree = parser.start();

        // Add custom error listener
        CustomErrorListener errorListener = new CustomErrorListener();
        parser.removeErrorListeners(); // Remove default error listeners
        parser.addErrorListener(errorListener);

        // Recording the steps here...
        stepsToNF.append("~ Lazer is now performing the syntax analysis [generating parse tree].\n");

        // Run the start non-terminal in the grammar
        ParseTree tree = parser.start();

        // To handle the error and display the necessary error message to the user...
        if(!errorListener.getErrors().isEmpty()) {
            String[] errors = errorListener.getErrors().split(", ");

            throw new LazerSyntaxErrorException("Syntax error(s) found!", errors);
        }

        // Recording the steps here...
        stepsToNF.append("?Parse tree returned in string format: ").append(tree.toStringTree(parser));

        // Sending the parse tree to be evaluated by the visitor (interpreter)
        // Recording the steps here...
        stepsToNF.append("~ Lazer is now performing the semantic analysis [checking the meaning].\n\n");

        // You can use the visitor to help evaluate expressions
        LazerWalker walker = new LazerWalker(tree.getText());
        String results = walker.visit(tree);

        // Recording the steps here...
        stepsToNF.append(walker.stepsToNormalForm());//.append("\n\n");

        stepsToNF.append("~ Free variables: ").append(walker.getFreeVariables());
        stepsToNF.append("~ Bound variables: ").append(walker.getBoundVariables()).append("\n\n");

        // return new String[] {walker.visit(tree), walker.stepsToNormalForm()};
        return new String[] {results, stepsToNF.toString()};
    }

    @Override
    public String promptAI(String code, String executionResults) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String systemContent = "You are an assistant for my application LazerEdit for my programming " +
                "language called Lazer. This is designed to evaluate only impure lambda calculus expressions. " +
                "Also keep in mind that if you see a # you should view it as the lambda sign (λ). Therefore, " +
                "let all of your responses be returned with # and not λ.";

        String prompt = "Work out (evaluate/reduce) this impure lambda calculus expression and show step by step working out with explanation: " + code +
                ". Keep in mind that the result I got for this is: " + executionResults + ". Also, use new line characters when doing the step by step working out.";


        String json = String.format("{"
                + "\"model\": \"%s\","
                + "\"messages\": ["
                + "    {\"role\": \"system\", \"content\": \"%s\"},"
                + "    {\"role\": \"user\", \"content\": \"%s\"}"
                + "],"
                + "\"max_tokens\": %s"
                + "}", novitaProperties.getModel(), systemContent, prompt, novitaProperties.getMaxTokens());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(novitaProperties.getUrl()))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + novitaProperties.getApiKey())
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.body());
        JsonNode choicesNode = rootNode.path("choices");

        if (choicesNode.isArray() && !choicesNode.isEmpty()) {
            JsonNode firstChoice = choicesNode.get(0);
            return firstChoice.path("message").path("content").asText();
        }

        return null;
    }

//     // Backup method to prompt AI
//     public String promptAI2(String code, String executionResults) throws IOException, InterruptedException {
//         HttpClient client = HttpClient.newHttpClient();

//         String systemContent = "You are an assistant for my application LazerEdit for my programming " +
//                 "language called Lazer. This is designed to evaluate only impure lambda calculus expressions. " +
//                 "Also keep in mind that if you see a # you should view it as the lambda sign (λ). Therefore, " +
//                 "let all of your responses be returned with # and not λ.";

//         String prompt = "Work out (evaluate/reduce) this impure lambda calculus expression and show step by step working out with explanation: " + code +
//                 ". Keep in mind that the result I got for this is: " + executionResults + ". Also, use new line characters when doing the step by step working out.";

//         String json = String.format("{" +
//                 "\"messages\":" +
//                 "[{\"role\":\"user\",\"content\":\"%s\"}]," +
//                 "\"system_prompt\":\"%s\"," +
//                 "\"temperature\":0.9," +
//                 "\"top_k\":5," +
//                 "\"top_p\":0.9," +
//                 "\"max_tokens\":512," +
//                 "\"web_access\":false}", prompt, systemContent);

//         HttpRequest request = HttpRequest.newBuilder()
//                 .uri(URI.create("https://chatgpt-42.p.rapidapi.com/conversationgpt4-2"))
//                 .header("x-rapidapi-key", "63bed532c2msh323a87f1b10dc40p17e98ejsnaa204a0b598f")
//                 .header("x-rapidapi-host", "chatgpt-42.p.rapidapi.com")
//                 .header("Content-Type", "application/json")
//                 .method("POST", HttpRequest.BodyPublishers.ofString(json))
//                 .build();

//         HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

//         ObjectMapper mapper = new ObjectMapper();
//         JsonNode rootNode = mapper.readTree(response.body());

//         return rootNode.get("result").asText();
//     }
}
