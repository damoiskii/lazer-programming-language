package com.devdam.server.antlr4;

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    private StringBuilder errorMessages;

    public CustomErrorListener(){
        errorMessages = new StringBuilder();
    }

    public String getErrors() {
        return errorMessages.toString();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorMessages.append("Syntax error at line ").append(line).append(":").append(charPositionInLine).append(" ").append(msg).append(", ");
        //errorMessages += "line " + line + ":" + charPositionInLine + " " + msg + ", ";
        //System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
