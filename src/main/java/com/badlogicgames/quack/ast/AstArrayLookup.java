package com.badlogicgames.quack.ast;

public class AstArrayLookup extends AstExpression {
	private AstExpression array;
	private AstExpression index;
	
	public AstArrayLookup (int line, int col) {
		super(line, col);
	}

	public AstExpression getArray () {
		return array;
	}

	public void setArray (AstExpression array) {
		this.array = array;
	}

	public AstExpression getIndex () {
		return index;
	}

	public void setIndex (AstExpression index) {
		this.index = index;
	}
}
