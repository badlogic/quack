
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(genericTypes, returnType, arguments, body);
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
		final AstAnonymousFunction other = (AstAnonymousFunction) obj;
		return Objects.equals(this.genericTypes, other.genericTypes) && Objects.equals(this.returnType, other.returnType) && Objects.equals(this.arguments, other.arguments) && Objects.equals(this.body, other.body);
	}
}
