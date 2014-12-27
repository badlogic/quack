
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstFunction extends AstNode {
	private String name;
	private final List<String> genericTypes = new ArrayList<>();
	private AstType returnType;
	private final List<AstArgument> arguments = new ArrayList<>();
	private final List<AstStatement> body = new ArrayList<>();

	public AstFunction (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
	
	public List<String> getGenericTypes () {
		return genericTypes;
	}

	public AstType getReturnType () {
		return returnType;
	}

	public void setReturnType(AstType returnType) {
		this.returnType = returnType;
	}

	public List<AstArgument> getArguments () {
		return arguments;
	}

	public List<AstStatement> getBody () {
		return body;
	}
}
