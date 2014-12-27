package com.badlogicgames.quack.ast;

public class AstLiteral extends AstExpression {
	public static enum LiteralType {
		Nil,
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
}
