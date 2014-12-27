package com.badlogicgames.quack.ast;

public class AstGetElement extends AstExpression {
	private AstExpression target;
	private AstReference element;
	
	public AstGetElement (int line, int col) {
		super(line, col);
	}

	public AstExpression getTarget () {
		return target;
	}

	public void setTarget (AstExpression target) {
		this.target = target;
	}

	public AstReference getElement () {
		return element;
	}

	public void setElement (AstReference element) {
		this.element = element;
	}
}
