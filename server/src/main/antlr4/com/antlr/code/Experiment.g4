// grammar Experiment;

// import LazerLexerRules;

// /********* Parser rules (syntax) **********/

// start: expression+ | EOF;

// expression: '('? VARIABLE ')'?
//     | '('? function arg ')'?
//     | '('? LAMBDA VARIABLE '.' expression ')'?
//     ;

// function: '('? VARIABLE ')'?
//     | '('? LAMBDA VARIABLE '.' expression ')'?
//     | '(' function arg ')'
//     | function arg
//     ;

// arg: '('? VARIABLE ')'?
//     | '(' LAMBDA VARIABLE '.' expression ')'
//     | '(' function arg ')'
//     ;
