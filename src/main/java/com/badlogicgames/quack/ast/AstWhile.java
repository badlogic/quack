package com.badlogicgames.quack.ast;

public class AstWhile extends AstStatement {
	private AstExpression condition;
	private AstBlock block;
	
	public AstWhile (int line, int col) {
		super(line, col);
	}

	public AstExpression getCondition () {
		return condition;
	}

	public void setCondition (AstExpression condition) {
		this.condition = condition;
	}

	public AstBlock getBlock () {
		return block;
	}

	public void setBlock (AstBlock block) {
		this.block = block;
	}
}
