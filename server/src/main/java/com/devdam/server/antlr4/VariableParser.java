package com.devdam.server.antlr4;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class VariableParser {
    //private String expression;
    private Result result;

    public VariableParser(String expression){
        //this.expression = expression;
        result = evaluateLambdaExpression(expression);
    }

    public void showResults(){
        System.out.println("Free Variables: " + result.freeVars());
        System.out.println("Bound Variables: " + result.boundVars());
    }

    public String getFreeVariables() {
        return result.freeVars().toString();
    }

    public String getBoundVariables() {
        return result.boundVars().toString();
    }

    public Result evaluateLambdaExpression(String expression) {
        Set<Character> freeVars = new HashSet<>();
        Set<Character> boundVars = new HashSet<>();
        Set<Character> usedVars = new HashSet<>();
        Stack<Set<Character>> boundStack = new Stack<>();

        parseLambda(expression, freeVars, boundVars, usedVars, boundStack);

        // Retain only those bound variables that are actually used in the expression
        boundVars.retainAll(usedVars);

        return new Result(freeVars, boundVars);
    }

    private void parseLambda(String expr, Set<Character> freeVars, Set<Character> boundVars, Stack<Set<Character>> boundStack) {
        int length = expr.length();
        int i = 0;

        while (i < length) {
            char currentChar = expr.charAt(i);

            if (currentChar == '#') {
                // Lambda abstraction, bind the variable
                i++; // Skip '#'

                if (i < length && Character.isLetter(expr.charAt(i))) {
                    char var = expr.charAt(i);
                    boundVars.add(var);

                    System.out.println("Bound var: " + var + "?\n");

                    if (boundStack.isEmpty()) {
                        boundStack.push(new HashSet<>());
                    }
                    /*else if (!Character.isLetter(expr.charAt(i - 2))) {
                        boundStack.push(new HashSet<>());
                    }*/
                    else if (!Character.isLetter(expr.charAt(i - 1))) {
                        boundStack.push(new HashSet<>());
                    }

                    boundStack.peek().add(var);
                    i++; // Skip the variable

                    if (i < length && expr.charAt(i) == '.') {
                        i++; // Skip '.'
                    }
                }
            }
            else if (Character.isLetter(currentChar)) {
                System.out.println("Current var: " + currentChar + "\n");

                // Variable
                if (!isBound(currentChar, boundStack)) {
                    freeVars.add(currentChar);

                    System.out.println("Free var: " + currentChar + "...\n");
                }
                i++; // Skip the variable
            }
            else if (currentChar == '(') {
                // Handle nested expressions by parsing within parentheses
                int start = i;
                int openBrackets = 1;
                i++;

                while (i < length && openBrackets > 0) {
                    if (expr.charAt(i) == '(') {
                        openBrackets++;
                    }
                    else if (expr.charAt(i) == ')') {
                        openBrackets--;
                    }

                    i++;
                }

                parseLambda(expr.substring(start + 1, i - 1), freeVars, boundVars, boundStack);
            }
            else {
                // Ignore spaces and other characters
                i++;
            }
        }
    }

    private void parseLambda(String expr, Set<Character> freeVars, Set<Character> boundVars, Set<Character> usedVars, Stack<Set<Character>> boundStack) {
        int length = expr.length();
        int i = 0;

        while (i < length) {
            char currentChar = expr.charAt(i);

            if (currentChar == '#') {
                // Lambda abstraction, bind the variable
                i++; // Skip '#'
                if (i < length && Character.isLetter(expr.charAt(i))) {
                    char var = expr.charAt(i);
                    if (!isBound(var, boundStack)) {
                        boundVars.add(var);
                        if (boundStack.isEmpty() || !Character.isLetter(expr.charAt(i - 1))) {
                            boundStack.push(new HashSet<>());
                        }
                        boundStack.peek().add(var);
                    }
                    i++; // Skip the variable
                    if (i < length && expr.charAt(i) == '.') {
                        i++; // Skip '.'
                    }
                }
            } else if (Character.isLetter(currentChar)) {
                // Variable
                usedVars.add(currentChar);
                if (!isBound(currentChar, boundStack)) {
                    freeVars.add(currentChar);
                }
                i++; // Skip the variable
            } else if (currentChar == '(') {
                // Handle nested expressions by parsing within parentheses
                int start = i;
                int openBrackets = 1;
                i++;
                while (i < length && openBrackets > 0) {
                    if (expr.charAt(i) == '(') {
                        openBrackets++;
                    } else if (expr.charAt(i) == ')') {
                        openBrackets--;
                    }
                    i++;
                }
                parseLambda(expr.substring(start + 1, i - 1), freeVars, boundVars, usedVars, boundStack);
            } else {
                // Ignore spaces and other characters
                i++;
            }
        }
    }
    
    private boolean isBound(char var, Stack<Set<Character>> boundStack) {
        for (Set<Character> boundSet : boundStack) {
            if (boundSet.contains(var)) {
                return true;
            }
        }

        return false;
    }

    // Result record
    private record Result(Set<Character> freeVars, Set<Character> boundVars) {}
}
