grammar LTSLazer;


start: expression+ | EOF;

expression: VARIABLE                    # Variable
    | NUMBER                            # Number
    | '#' VARIABLE '.' expression       # Abstraction
    | expression expression             # Application
    | '(' expression ')'                # Parenthesis
    | operator expression               # Operation
    ;

operator: PLUS
    | MINUS
    | DIVIDE
    | MULTIPLY
    ;


/********* Lexer rules (tokens) **********/

// Punctuation
DOT: '.';
OPAREN: '(' ;
CPAREN: ')' ;

LAMBDA: '#';


// Operators
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';


// Identifiers
VARIABLE: [a-z];


// Numbers
NUMBER: [0-9]+;


// Ignore
WHITESPACE: [ \t\r\n]+ -> skip;


// Single-line comments
COMMENT: '//' ~[\r\n]* -> skip;

// Multi-line comments
COMMENT_MULTI: '/*' .*? '*/' -> skip;