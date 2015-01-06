package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstCall extends AstExpression {
	private AstExpression target;
	private final List<AstType> genericTypes = new ArrayList<>();
	private final List<AstExpression> arguments = new ArrayList<>();
	
	public AstCall (int line, int col) {
		super(line, col);
	}

	public List<AstExpression> getArguments () {
		return arguments;
	}
	
	public List<AstType> getGenericTypes () {
		return genericTypes;
	}

	public AstExpression getTarget () {
		return target;
	}

	public void setTarget (AstExpression target) {
		this.target = target;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(target, genericTypes, arguments);
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
		final AstCall other = (AstCall) obj;
		return Objects.equals(this.target, other.target) && Objects.equals(this.genericTypes, other.genericTypes) && Objects.equals(this.arguments, other.arguments);
	}
}
