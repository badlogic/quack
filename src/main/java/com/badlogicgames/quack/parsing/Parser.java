package com.badlogicgames.quack.parsing;

import com.badlogicgames.quack.ast.AstCompilationUnit;
import com.badlogicgames.quack.ast.AstGenerator;
import com.badlogicgames.quack.parsing.antlr.QuackLexer;
import com.badlogicgames.quack.parsing.antlr.QuackParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Parser {

    public AstCompilationUnit parse(String source) {
        try {
            return parse(new ByteArrayInputStream(source.getBytes("UTF-8")));
        } catch (IOException e) {
            throw new ParserException("Couldn't convert string to bytes");
        }
    }

    public AstCompilationUnit parse(InputStream in) throws IOException {
        try {
            ErrorHandler errorHandler = new ErrorHandler();
            AstGenerator astGenerator = new AstGenerator();

            QuackLexer lexer = new QuackLexer(new ANTLRInputStream(in));
            QuackParser parser = new QuackParser(new CommonTokenStream(lexer));
            parser.setTrace(true);
            parser.setErrorHandler(errorHandler);
            parser.addParseListener(astGenerator);
            parser.compilationUnit();

            return astGenerator.getCompilationUnit();
        } catch(Throwable t) {
            throw new ParserException("Error while parsing", t);
        }
    }
}
