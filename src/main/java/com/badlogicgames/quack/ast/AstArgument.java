package com.badlogicgames.quack.ast;

public class AstArgument extends AstNode {
	private String name;
	private AstType type;
	private AstExpression defaultValue;
	
	public AstArgument (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public AstType getType () {
		return type;
	}

	public void setType (AstType type) {
		this.type = type;
	}

	public AstExpression getDefaultValue () {
		return defaultValue;
	}

	public void setDefaultValue (AstExpression defaultValue) {
		this.defaultValue = defaultValue;
	}
}
