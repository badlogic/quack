package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

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
}
