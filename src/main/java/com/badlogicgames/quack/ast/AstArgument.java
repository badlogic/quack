package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstArgument extends AstNode {
	private String name;
	private AstType type;
	private AstExpression defaultValue;
	
	public AstArgument (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public AstType getType () {
		return type;
	}

	public void setType (AstType type) {
		this.type = type;
	}

	public AstExpression getDefaultValue () {
		return defaultValue;
	}

	public void setDefaultValue (AstExpression defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(name, type, defaultValue);
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
		final AstArgument other = (AstArgument) obj;
		return Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type) && Objects.equals(this.defaultValue, other.defaultValue);
	}
}
