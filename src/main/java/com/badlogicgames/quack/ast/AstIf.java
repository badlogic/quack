package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstIf extends AstStatement {
	private AstExpression condition;
	private AstBlock trueBlock;
	private List<AstElif> elseIfs = new ArrayList<>();
	private AstBlock elseBlock;
	
	public AstIf (int line, int col) {
		super(line, col);
	}

	public AstExpression getCondition () {
		return condition;
	}

	public void setCondition (AstExpression condition) {
		this.condition = condition;
	}

	public AstBlock getTrueBlock () {
		return trueBlock;
	}

	public void setTrueBlock (AstBlock trueBlock) {
		this.trueBlock = trueBlock;
	}

	public List<AstElif> getElseIfs () {
		return elseIfs;
	}

	public void setElseIfs (List<AstElif> elseIfs) {
		this.elseIfs = elseIfs;
	}

	public AstBlock getElseBlock () {
		return elseBlock;
	}

	public void setElseBlock (AstBlock elseBlock) {
		this.elseBlock = elseBlock;
	}
}
