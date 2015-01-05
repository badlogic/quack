package com.badlogicgames.quack;

import java.io.IOException;
import java.io.InputStream;

import com.badlogicgames.quack.ast.AstGenerator;
import com.badlogicgames.quack.parsing.ErrorHandler;
import com.badlogicgames.quack.parsing.antlr.QuackLexer;
import com.badlogicgames.quack.parsing.antlr.QuackParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.badlogicgames.quack.ast.AstCompilationUnit;
import com.badlogicgames.quack.ast.AstFunction;
import com.badlogicgames.quack.ast.AstStruct;
import com.badlogicgames.quack.ast.utils.AstGraphViz;
import com.badlogicgames.quack.parsing.ParseException;
import com.badlogicgames.quack.parsing.Parser;

import static org.junit.Assert.assertTrue;

public class ParserTest {
	@Test
	public void testParser() throws ParseException {
		Parser parser = new Parser(open("test1.qk"));
		AstCompilationUnit cu = parser.CompilationUnit();
		for(AstFunction fun: cu.getFunctions()) {
			System.out.println(AstGraphViz.buildGraphViz(fun));
		}
		for(AstStruct str: cu.getStructs()) {
			System.out.println(AstGraphViz.buildGraphViz(str));
		}
	}

	@Test
	public void testAntlrParser() throws IOException {
		ErrorHandler errorHandler = new ErrorHandler();
		AstGenerator astGenerator = new AstGenerator();

		QuackLexer lexer = new QuackLexer(new ANTLRInputStream(open("test1.qk")));
		QuackParser parser = new QuackParser(new CommonTokenStream(lexer));
		parser.setErrorHandler(errorHandler);
		parser.addParseListener(astGenerator);
		parser.compilationUnit();

		AstCompilationUnit cu = astGenerator.getCompilationUnit();
		System.out.println(AstGraphViz.buildGraphViz(cu));
//		for(AstFunction fun: cu.getFunctions()) {
//			System.out.println(AstGraphViz.buildGraphViz(fun));
//		}
//		for(AstStruct str: cu.getStructs()) {
//			System.out.println(AstGraphViz.buildGraphViz(str));
//		}
	}
	
	private static InputStream open(String file) {
		try {
			return ParserTest.class.getResourceAsStream("/" + file);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
