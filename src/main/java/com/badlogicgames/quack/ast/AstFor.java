package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstFor extends AstStatement {
	private final List<AstStatement> initializers = new ArrayList<>();
	private AstExpression condition;
	private final List<AstStatement> bottom = new ArrayList<>();
	private AstBlock block;
	
	public AstFor (int line, int col) {
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

	public List<AstStatement> getInitializers () {
		return initializers;
	}

	public List<AstStatement> getBottom () {
		return bottom;
	}
}
