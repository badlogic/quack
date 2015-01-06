package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstBlock extends AstStatement {
	private final List<AstStatement> statements = new ArrayList<>();
	public AstBlock (int line, int col) {
		super(line, col);
	}
	public List<AstStatement> getStatements () {
		return statements;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(statements);
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
		final AstBlock other = (AstBlock) obj;
		return Objects.equals(this.statements, other.statements);
	}
}
