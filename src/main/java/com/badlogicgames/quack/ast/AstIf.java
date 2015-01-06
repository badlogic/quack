package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstIf extends AstStatement {
	private AstExpression condition;
	private AstBlock trueBlock;
	private List<AstElif> elseIfs = new ArrayList<>();
	private AstBlock elseBlock;
	
	public AstIf (int line, int col) {
		super(line, col);
	}

	public AstExpression getCondition () {
		return condition;
	}

	public void setCondition (AstExpression condition) {
		this.condition = condition;
	}

	public AstBlock getTrueBlock () {
		return trueBlock;
	}

	public void setTrueBlock (AstBlock trueBlock) {
		this.trueBlock = trueBlock;
	}

	public List<AstElif> getElseIfs () {
		return elseIfs;
	}

	public void setElseIfs (List<AstElif> elseIfs) {
		this.elseIfs = elseIfs;
	}

	public AstBlock getElseBlock () {
		return elseBlock;
	}

	public void setElseBlock (AstBlock elseBlock) {
		this.elseBlock = elseBlock;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(condition, trueBlock, elseIfs, elseBlock);
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
		final AstIf other = (AstIf) obj;
		return Objects.equals(this.condition, other.condition) && Objects.equals(this.trueBlock, other.trueBlock) && Objects.equals(this.elseIfs, other.elseIfs) && Objects.equals(this.elseBlock, other.elseBlock);
	}
}
