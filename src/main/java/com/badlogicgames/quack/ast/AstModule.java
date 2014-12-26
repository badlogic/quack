
package com.badlogicgames.quack.ast;

public class AstModule extends AstNode {
	private String name;

	public AstModule (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
}
