package com.badlogicgames.quack.ast;

public class AstLogical extends AstBinary {
	public static enum LogicalOperator {
		And,
		Or
	}
	
	private LogicalOperator operator;	
	
	public AstLogical (int line, int col) {
		super(line, col);
	}

	public LogicalOperator getOperator () {
		return operator;
	}

	public void setOperator (LogicalOperator operator) {
		this.operator = operator;
	}
}
