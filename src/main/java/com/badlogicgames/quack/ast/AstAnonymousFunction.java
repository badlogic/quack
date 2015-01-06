
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

public class AstAnonymousFunction extends AstExpression {
	private final List<AstType> genericTypes = new ArrayList<>();
	private AstType returnType;
	private final List<AstArgument> arguments = new ArrayList<>();
	private final List<AstStatement> body = new ArrayList<>();

	public AstAnonymousFunction(int line, int col) {
		super(line, col);
	}

	public List<AstType> getGenericTypes() {
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
