package com.badlogicgames.quack.ast;

public class AstDereference extends AstExpression {
	private AstExpression target;
	private AstExpression element;
	
	public AstDereference(int line, int col) {
		super(line, col);
	}

	public AstExpression getTarget () {
		return target;
	}

	public void setTarget (AstExpression target) {
		this.target = target;
	}

	public AstExpression getElement() {
		return element;
	}

	public void setElement (AstReference element) {
		this.element = element;
	}
}
