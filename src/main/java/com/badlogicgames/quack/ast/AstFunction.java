
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstFunction extends AstNode {
	private String name;
	private AstType returnType;
	private final List<AstNode> arguments = new ArrayList<>();
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

	public AstType getReturnType () {
		return returnType;
	}

	public void setReturnType(AstType returnType) {
		this.returnType = returnType;
	}

	public List<AstNode> getArguments () {
		return arguments;
	}

	public List<AstStatement> getBody () {
		return body;
	}
}
