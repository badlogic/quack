package com.badlogicgames.quack.ast;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(target, element);
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
		final AstDereference other = (AstDereference) obj;
		return Objects.equals(this.target, other.target) && Objects.equals(this.element, other.element);
	}
}
