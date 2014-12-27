
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstStruct extends AstNode {
	private String name;
	private final List<AstVariableDeclaration> fields = new ArrayList<>();
	private final List<AstFunction> functions = new ArrayList<>();

	public AstStruct (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}

	public List<AstVariableDeclaration> getFields () {
		return fields;
	}

	public List<AstFunction> getFunctions () {
		return functions;
	}
}
