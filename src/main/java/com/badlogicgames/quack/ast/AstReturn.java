package com.badlogicgames.quack.ast;

public class AstReturn extends AstExpression {
	private AstExpression value;
	
	public AstReturn (int line, int col) {
		super(line, col);
	}

	public AstExpression getValue () {
		return value;
	}

	public void setValue (AstExpression value) {
		this.value = value;
	}
}
