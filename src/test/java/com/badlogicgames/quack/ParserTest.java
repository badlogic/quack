package com.badlogicgames.quack;

import java.io.InputStream;

import org.junit.Test;

import com.badlogicgames.quack.parsing.ParseException;
import com.badlogicgames.quack.parsing.Parser;

public class ParserTest {
	@Test
	public void testParser() throws ParseException {
		Parser parser = new Parser(open("test1.qk"));
		parser.CompilationUnit();
	}
	
	private static InputStream open(String file) {
		try {
			return ParserTest.class.getResourceAsStream("/" + file);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
