
package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstVariableDeclaration extends AstStatement {
	public static enum Qualifier {
		Val,
		Var
	}
	
	private boolean isStatic;
	private Qualifier qualifier;
	private String name;
	private AstType type;
	private AstExpression initializer;

	public AstVariableDeclaration (int line, int col) {
		super(line, col);
	}		

	public boolean isStatic () {
		return isStatic;
	}

	public void setStatic (boolean isStatic) {
		this.isStatic = isStatic;
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

	public AstExpression getInitializer () {
		return initializer;
	}

	public void setInitializer (AstExpression initializer) {
		this.initializer = initializer;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(isStatic, qualifier, name, type, initializer);
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
		final AstVariableDeclaration other = (AstVariableDeclaration) obj;
		return Objects.equals(this.isStatic, other.isStatic) && Objects.equals(this.qualifier, other.qualifier) && Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type) && Objects.equals(this.initializer, other.initializer);
	}
}
