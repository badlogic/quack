package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstArrayAccess extends AstExpression {
	private AstExpression array;
	private AstExpression index;
	
	public AstArrayAccess(int line, int col) {
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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(array, index);
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
		final AstArrayAccess other = (AstArrayAccess) obj;
		return Objects.equals(this.array, other.array) && Objects.equals(this.index, other.index);
	}
}
