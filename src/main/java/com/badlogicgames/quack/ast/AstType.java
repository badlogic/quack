package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

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
}
