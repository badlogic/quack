package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstType extends AstNode {
	private String name;
	private final List<AstType> genericTypes = new ArrayList<>();
	private final List<AstArgument> arguments = new ArrayList<>();
	private AstType returnType;
	
	public AstType (int line, int col) {		
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public List<AstType> getGenericTypes () {
		return genericTypes;
	}

	public List<AstArgument> getArguments () {
		return arguments;
	}

	public AstType getReturnType () {
		return returnType;
	}

	public void setReturnType (AstType returnType) {
		this.returnType = returnType;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(name, genericTypes, arguments, returnType);
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
		final AstType other = (AstType) obj;
		return Objects.equals(this.name, other.name) && Objects.equals(this.genericTypes, other.genericTypes) && Objects.equals(this.arguments, other.arguments) && Objects.equals(this.returnType, other.returnType);
	}
}
