package com.devdam.server.antlr4;

import com.z_antlr.generated.LazerLexer;
import com.z_antlr.generated.LazerParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrTest {
    public static void main(String[] args) {
        CodePointCharStream input = CharStreams.fromString("#x.x (x y) x");

        LazerLexer lexer = new LazerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LazerParser parser = new LazerParser(tokens);
        ParseTree tree = parser.start(); // parse; start at prog

        System.out.println(tree.toStringTree(parser)); // print tree as text

        // You can use the visitor to help evaluate expressions

    }
}
