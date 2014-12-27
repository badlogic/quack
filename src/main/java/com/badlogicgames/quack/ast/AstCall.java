package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstCall extends AstExpression {
	private AstExpression target;
	private final List<AstExpression> arguments = new ArrayList<AstExpression>();
	
	public AstCall (int line, int col) {
		super(line, col);
	}

	public List<AstExpression> getArguments () {
		return arguments;
	}

	public AstExpression getTarget () {
		return target;
	}

	public void setTarget (AstExpression target) {
		this.target = target;
	}
}
