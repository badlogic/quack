package com.badlogicgames.quack.ast;

public class AstArgumentExpression extends AstExpression {
	private String argName;
	private AstExpression expression;
	
	public AstArgumentExpression (int line, int col) {
		super(line, col);
	}

	public String getArgumentName () {
		return argName;
	}

	public void setArgumentName(String argName) {
		this.argName = argName;
	}

	public AstExpression getExpression () {
		return expression;
	}

	public void setExpression (AstExpression expression) {
		this.expression = expression;
	}
}
