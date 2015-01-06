package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstArgumentExpression extends AstExpression {
	private String argName;
	private AstExpression expression;
	
	public AstArgumentExpression (int line, int col) {
		super(line, col);
	}

	public String getArgumentName () {
		return argName;
	}

	public void setArgumentName(String argName) {
		this.argName = argName;
	}

	public AstExpression getExpression () {
		return expression;
	}

	public void setExpression (AstExpression expression) {
		this.expression = expression;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(argName, expression);
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
		final AstArgumentExpression other = (AstArgumentExpression) obj;
		return Objects.equals(this.argName, other.argName) && Objects.equals(this.expression, other.expression);
	}
}
