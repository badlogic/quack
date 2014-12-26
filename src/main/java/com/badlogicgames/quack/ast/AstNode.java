
package com.badlogicgames.quack.ast;

public class AstNode {
	private final int line;
	private final int col;

	public AstNode (int line, int col) {
		this.line = line;
		this.col = col;
	}

	public int getLine () {
		return line;
	}

	public int getCol () {
		return col;
	}
}
