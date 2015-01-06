package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstBinaryOp extends AstExpression {
	public static enum Operator {
		Assign,
		LogicalAnd,
		LogicalOr,
		BinaryAnd,
		BinaryOr,
		BinaryXor,
		Equal,
		NotEqual,
		LessThan,
		LessOrEqual,
		GreaterThan,
		GreaterOrEqual,
		ShiftLeft,
		ShiftRight,
		Add,
		Subtract,
		Multiply,
		Divide,
		Modulo;		
		
		public static Operator fromString(String op) {
			switch(op) {
			case "=": return Assign;
			case "&&": return LogicalAnd;
			case "||": return LogicalOr;
			case "&": return BinaryAnd;
			case "|": return BinaryOr;
			case "^": return BinaryXor;
			case "==": return Equal;
			case "!=": return NotEqual;
			case "<": return LessThan;
			case "<=": return LessOrEqual;
			case ">": return GreaterThan;
			case ">=": return GreaterOrEqual;
			case "<<": return ShiftLeft;
			case ">>": return ShiftRight;
			case "+": return Add;
			case "-": return Subtract;
			case "*": return Multiply;
			case "/": return Divide;
			case "%": return Modulo;
			default:
				throw new RuntimeException("Unknown operator: '" + op + "'");
			}
		}
	}
	
	private AstExpression leftHandSide;
	private AstExpression rightHandSide;
	private Operator operator;

	public AstBinaryOp (int line, int col) {
		super(line, col);
	}

	public AstExpression getLeftHandSide () {
		return leftHandSide;
	}

	public void setLeftHandSide (AstExpression leftHandSide) {
		this.leftHandSide = leftHandSide;
	}

	public AstExpression getRightHandSide () {
		return rightHandSide;
	}

	public void setRightHandSide (AstExpression rightHandSide) {
		this.rightHandSide = rightHandSide;
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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(leftHandSide, rightHandSide, operator);
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
		final AstBinaryOp other = (AstBinaryOp) obj;
		return Objects.equals(this.leftHandSide, other.leftHandSide) && Objects.equals(this.rightHandSide, other.rightHandSide) && Objects.equals(this.operator, other.operator);
	}
}
