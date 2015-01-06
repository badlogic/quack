package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(initializers, condition, bottom, block);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		final AstFor other = (AstFor) obj;
		return Objects.equals(this.initializers, other.initializers) && Objects.equals(this.condition, other.condition) && Objects.equals(this.bottom, other.bottom) && Objects.equals(this.block, other.block);
	}
}
