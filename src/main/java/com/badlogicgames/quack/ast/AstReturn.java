package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstReturn extends AstStatement {
	private AstExpression value;
	
	public AstReturn (int line, int col) {
		super(line, col);
	}

	public AstExpression getValue () {
		return value;
	}

	public void setValue (AstExpression value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(value);
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
		final AstReturn other = (AstReturn) obj;
		return Objects.equals(this.value, other.value);
	}
}
