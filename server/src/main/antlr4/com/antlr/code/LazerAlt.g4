// grammar Lazer;



// /********* Lexer rules (tokens) **********/
// // Punctuation
// DOT: '.';
// LPAREN: '(' ;
// RPAREN: ')' ;
// ENDLINE: ';';

// LAMBDA: '#' | '\u03BB'; // -> '\u03BB' = λ

// // Operators
// ASSIGN: '=';
// PLUS: '+';
// MINUS: '-';
// MULTIPLY: '*';
// DIVIDE: '/';

// // Identifiers
// VAR: [a-zA-Z];

// // Literal
// INT: [0-9];

// // Ignore
// WHITESPACE: [ \t\r\n]+ -> skip;



// /********* Parser rules (syntax) **********/
// start: (expression ENDLINE)+                #Line
//     | EOF                                   #EndOfFile
//     ;

// expression: function argument               #ExpApp
//     | LAMBDA VAR DOT expression             #ExpAbs
//     | arithmetic                            #ExpArith
//     | VAR                                   #ExpVar
//     | INT                                   #ExpInt
//     | LPAREN expression RPAREN              #ExpBrackets
//     ;

// function: VAR                               #FuncVar
//     | LAMBDA VAR DOT expression             #FuncAbs
//     | function argument                     #FuncApp
//     | LPAREN function RPAREN                #FuncBrackets
//     ;

// argument: VAR                               #ArgVar
//     | INT                                   #ArgInt
//     | function argument                     #ArgApp
//     | LAMBDA VAR DOT expression             #ArgAbs
//     | arithmetic                            #ArgArith
//     | LPAREN argument RPAREN                #ArgBrackets
//     ;

// arithmetic: operator INT INT                #ArithIntInt
//     | operator INT VAR                      #ArithIntVar
//     | operator VAR VAR                      #ArithVarVar
//     | operator VAR INT                      #ArithVarInt
//     | operator expression INT               #ArithExpInt
//     | operator expression VAR               #ArithExpVar
//     | operator INT expression               #ArithIntExp
//     | operator VAR expression               #ArithVarExp
//     ;

// operator: PLUS                              #OpPlus
//     | MINUS                                 #OpMinus
//     | DIVIDE                                #OpDiv
//     | MULTIPLY                              #OpMult
//     ;
