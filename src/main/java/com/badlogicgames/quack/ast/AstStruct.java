
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstStruct extends AstNode {
	private String name;
	private final List<String> genericTypes = new ArrayList<>();
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

	public List<String> getGenericTypes () {
		return genericTypes;
	}

	public List<AstVariableDeclaration> getFields () {
		return fields;
	}

	public List<AstFunction> getFunctions () {
		return functions;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(name, genericTypes, fields, functions);
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
		final AstStruct other = (AstStruct) obj;
		return Objects.equals(this.name, other.name) && Objects.equals(this.genericTypes, other.genericTypes) && Objects.equals(this.fields, other.fields) && Objects.equals(this.functions, other.functions);
	}
}
