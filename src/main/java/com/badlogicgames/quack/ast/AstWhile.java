package com.badlogicgames.quack.ast;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(condition, block);
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
		final AstWhile other = (AstWhile) obj;
		return Objects.equals(this.condition, other.condition) && Objects.equals(this.block, other.block);
	}
}
