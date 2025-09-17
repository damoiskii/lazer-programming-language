grammar Lazer;

import LazerLexerRules;

/********* Parser rules (syntax) **********/

start: expression+ | EOF;

expression: VARIABLE                    # Variable
    | NUMBER                            # Number
    | '#' VARIABLE '.' expression       # Abstraction
    | expression expression             # Application
    | '(' expression ')'                # Parenthesis
    ;
