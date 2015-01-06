package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstLiteral extends AstExpression {
	public static enum LiteralType {
		Null,
		Boolean,
		Integer,
		Float,
		Character,
		String
	}
	
	private String value;
	private LiteralType type;
	
	public AstLiteral (int line, int col) {
		super(line, col);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public LiteralType getLiteralType () {
		return type;
	}

	public void setLiteralType (LiteralType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(value, type);
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
		final AstLiteral other = (AstLiteral) obj;
		return Objects.equals(this.value, other.value) && Objects.equals(this.type, other.type);
	}
}
