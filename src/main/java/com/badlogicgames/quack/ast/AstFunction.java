
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	public List<String> getGenericParameters() {
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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(name, genericTypes, returnType, arguments, body);
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
		final AstFunction other = (AstFunction) obj;
		return Objects.equals(this.name, other.name) && Objects.equals(this.genericTypes, other.genericTypes) && Objects.equals(this.returnType, other.returnType) && Objects.equals(this.arguments, other.arguments) && Objects.equals(this.body, other.body);
	}
}
