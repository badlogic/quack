package com.badlogicgames.quack.ast;

public class AstUnaryOp extends AstExpression {
	public static enum Operator {
		Not,
		Plus,
		Minus,
		TypeOf,
		SizeOf;
		
		public static Operator fromString(String op) {
			switch(op) {
			case "!": return Not;
			case "+": return Plus;
			case "-": return Minus;
			case "typeof": return TypeOf;
			case "sizeof": return SizeOf;
			default:
				throw new RuntimeException("Unknown operator: '" + op + "'");
			}
		}
	}
	
	private Operator operator;
	private AstExpression expression;
	private AstType type;
	
	public AstUnaryOp (int line, int col) {
		super(line, col);		
	}

	public Operator getOperator () {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = Operator.fromString(operator);
	}
	
	public void setOperator (Operator operator) {
		this.operator = operator;
	}

	public AstExpression getExpression () {
		return expression;
	}

	public void setExpression (AstExpression expression) {
		this.expression = expression;
	}

	public AstType getType () {
		return type;
	}

	public void setType (AstType type) {
		this.type = type;
	}	
}
