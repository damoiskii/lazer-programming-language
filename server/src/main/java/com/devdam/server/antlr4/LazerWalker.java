package com.devdam.server.antlr4;


import com.z_antlr.generated.LazerBaseVisitor;
import com.z_antlr.generated.LazerParser;


public class LazerWalker extends LazerBaseVisitor<String> {
    private StringBuilder stepsToNF;
    private VariableParser variableParser;

    public LazerWalker(){
        stepsToNF = new StringBuilder();
    }

    public LazerWalker(String expression){
        stepsToNF = new StringBuilder();
        variableParser = new VariableParser(expression);
    }

    public String stepsToNormalForm(){
        return stepsToNF.toString();
    }

    public String getFreeVariables() {
        return variableParser.getFreeVariables();
    }

    public String getBoundVariables() {
        return variableParser.getBoundVariables();
    }

    @Override
    public String visitApplication(LazerParser.ApplicationContext ctx) {
        String function = visit(ctx.expression(0));
        String argument = visit(ctx.expression(1));

        //System.out.println("Application: Applying arg{" + argument + "} to func{" + function + "}");

        if (function.startsWith("#")) {
            stepsToNF.append("?Using beta reduction to reduce expression: ").append(function).append(argument);

            String applied = apply(function, argument).replaceAll("#", " #").trim();
            stepsToNF.append("= ").append(applied).append("\n");

            // If there are more than 1 # (lambda functions)
            int lastIndex = applied.lastIndexOf("#");
            if(lastIndex > 0){
                return super.visitApplication(ctx);
            }

            return applied;
        }

        return function + " " + argument;
    }

    @Override
    public String visitAbstraction(LazerParser.AbstractionContext ctx) {
        //System.out.println("Abstraction: " + "#" + ctx.VARIABLE().getText() + "." + visit(ctx.expression()) + "\n");
        return "#" + ctx.VARIABLE().getText() + "." + visit(ctx.expression());
    }

    @Override
    public String visitVariable(LazerParser.VariableContext ctx) {
        //System.out.println("Variable: " + ctx.ID().getText() + "\n");
        return ctx.VARIABLE().getText();
    }

    @Override
    public String visitNumber(LazerParser.NumberContext ctx) {
        //System.out.println("Number: " + ctx.NUMBER().getText() + "\n");
        return ctx.NUMBER().getText();
    }

    @Override
    public String visitParenthesis(LazerParser.ParenthesisContext ctx) {
        //System.out.println("Parenthesis: (" + visit(ctx.expression()) + ")\n");
        // return "(" + visit(ctx.expression()) + ")";
        return visit(ctx.expression());
    }

    private String apply(String function, String argument) {
        // Extract variable and body from "#var. body"
        String[] parts = function.split("\\.", 2);
        String var = parts[0].replace("#", "").trim();
        String body = parts[1].trim();

        return substitute(body, var, argument);
    }

    private String substitute(String body, String var, String arg) {
        //System.out.println("\t\t\t → β [arg{" + arg + "} / var{" + var + "}] body{" + body + "}");
        stepsToNF.append("\t\t\t → β [arg{").append(arg).append("} / var{").append(var).append("}] body{").append(body).append("}");
        return body.replace(var, arg);
    }
}