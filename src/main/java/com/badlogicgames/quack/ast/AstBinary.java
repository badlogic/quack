package com.badlogicgames.quack.ast;

public class AstBinary extends AstExpression {
	
	private AstExpression leftHandSide;
	private AstExpression rightHandSide;

	public AstBinary (int line, int col) {
		super(line, col);
	}

	public AstExpression getLeftHandSide () {
		return leftHandSide;
	}

	public void setLeftHandSide (AstExpression leftHandSide) {
		this.leftHandSide = leftHandSide;
	}

	public AstExpression getRightHandSide () {
		return rightHandSide;
	}

	public void setRightHandSide (AstExpression rightHandSide) {
		this.rightHandSide = rightHandSide;
	}
}
