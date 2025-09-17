package com.devdam.server.error;

import java.util.Arrays;

public class LazerSyntaxErrorException extends Exception {
    private String[] multipleErrors;

    public LazerSyntaxErrorException(String message, String[] multipleErrors){
        super(message);

        this.multipleErrors = multipleErrors;
    }

    public String getMultipleErrors() {
        return Arrays.toString(multipleErrors);
    }
}
