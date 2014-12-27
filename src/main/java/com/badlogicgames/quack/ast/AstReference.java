package com.badlogicgames.quack.ast;

public class AstReference extends AstExpression {
	private String name;
	
	public AstReference (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
}
