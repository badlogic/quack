package com.badlogicgames.quack;

import java.io.IOException;
import java.io.InputStream;

import com.badlogicgames.quack.parsing.ErrorHandler;
import com.badlogicgames.quack.parsing.Parser;
import org.junit.Test;

import com.badlogicgames.quack.ast.utils.AstGraphViz;

import static org.junit.Assert.assertTrue;

public class ParserTest {
	@Test
	public void testParser() throws IOException {
		Parser parser = new Parser();
		Parser.ParserResult result = parser.parse(open("test1.qk"));
		printErrors(result);
		assertTrue(result.getErrors().isEmpty());
		System.out.println(AstGraphViz.buildGraphViz(result.getCompilationUnit()));
	}
	
	private static InputStream open(String file) {
		try {
			return ParserTest.class.getResourceAsStream("/" + file);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}

	private void printErrors(Parser.ParserResult result) {
		if(!result.getErrors().isEmpty()) {
			for(ErrorHandler.Error e: result.getErrors()) {
				System.out.println(e.getMsg());
			}
		}
	}
}
