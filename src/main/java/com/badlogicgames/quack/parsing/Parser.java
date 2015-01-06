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
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Parser {
    public final class ParserResult {
        private final AstCompilationUnit cu;
        private final List<ErrorHandler.Error> errors;

        public ParserResult(AstCompilationUnit cu, List<ErrorHandler.Error> errors) {
            this.cu = cu;
            this.errors = errors;
        }

        public AstCompilationUnit getCompilationUnit() {
            return cu;
        }

        public List<ErrorHandler.Error> getErrors() {
            return errors;
        }
    }

    public ParserResult parse(String source) {
        try {
            return parse(new ByteArrayInputStream(source.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new ParserException("Couldn't convert string to bytes", e);
        }
    }

    public ParserResult parse(InputStream in) {
        ErrorHandler errorHandler = new ErrorHandler();
        AstGenerator astGenerator = new AstGenerator(errorHandler);
        try {
            QuackLexer lexer = new QuackLexer(new ANTLRInputStream(in));
            QuackParser parser = new QuackParser(new CommonTokenStream(lexer));
            parser.setTrace(false);
            parser.removeErrorListeners(); // remove default listener which prints to stderr
            parser.addErrorListener(errorHandler);
            parser.addParseListener(astGenerator);
            parser.compilationUnit();

            return new ParserResult(astGenerator.getCompilationUnit(), errorHandler.getErrors());
        } catch(Throwable t) {
            errorHandler.getErrors().add(new ErrorHandler.Error(1, 1, 1, 1, "Unknown error: " + t));
            return new ParserResult(new AstCompilationUnit(1, 1), errorHandler.getErrors());
        }
    }
}
