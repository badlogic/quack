package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstBlock extends AstStatement {
	private final List<AstStatement> statements = new ArrayList<>();
	public AstBlock (int line, int col) {
		super(line, col);
	}
	public List<AstStatement> getStatements () {
		return statements;
	}
}
