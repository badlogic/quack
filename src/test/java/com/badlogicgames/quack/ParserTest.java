package com.badlogicgames.quack;

import java.io.InputStream;

import org.junit.Test;

import com.badlogicgames.quack.ast.AstCompilationUnit;
import com.badlogicgames.quack.ast.AstFunction;
import com.badlogicgames.quack.ast.AstStruct;
import com.badlogicgames.quack.ast.utils.AstGraphViz;
import com.badlogicgames.quack.parsing.ParseException;
import com.badlogicgames.quack.parsing.Parser;

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
	
	private static InputStream open(String file) {
		try {
			return ParserTest.class.getResourceAsStream("/" + file);
		} catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
