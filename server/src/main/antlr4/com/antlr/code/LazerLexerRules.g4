lexer grammar LazerLexerRules;

/********* Lexer rules (tokens) **********/

// Punctuation
DOT: '.';
OPAREN: '(' ;
CPAREN: ')' ;

LAMBDA: '#';


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