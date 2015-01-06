package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstReference extends AstExpression {
	private String name;
	
	public AstReference (int line, int col) {
		super(line, col);
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(name);
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
		final AstReference other = (AstReference) obj;
		return Objects.equals(this.name, other.name);
	}
}
