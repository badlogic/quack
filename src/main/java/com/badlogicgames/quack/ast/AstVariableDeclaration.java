
package com.badlogicgames.quack.ast;

public class AstVariableDeclaration extends AstStatement {
	public static enum Qualifier {
		Val,
		Var
	}
	
	private Qualifier qualifier;
	private String name;
	private AstType type;

	public AstVariableDeclaration (int line, int col) {
		super(line, col);
	}

	public Qualifier getQualifier () {
		return qualifier;
	}

	public void setQualifier (Qualifier qualifier) {
		this.qualifier = qualifier;
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
}
