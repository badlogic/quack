package com.badlogicgames.quack.ast;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(operator, expression);
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
		final AstUnaryOp other = (AstUnaryOp) obj;
		return Objects.equals(this.operator, other.operator) && Objects.equals(this.expression, other.expression);
	}
}
