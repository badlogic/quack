package com.badlogicgames.quack.ast;

public class AstArgumentExpression extends AstExpression {
	private String fieldName;
	private AstExpression expression;
	
	public AstArgumentExpression (int line, int col) {
		super(line, col);
	}

	public String getFieldName () {
		return fieldName;
	}

	public void setFieldName (String fieldName) {
		this.fieldName = fieldName;
	}

	public AstExpression getExpression () {
		return expression;
	}

	public void setExpression (AstExpression expression) {
		this.expression = expression;
	}
}
