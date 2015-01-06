
package com.badlogicgames.quack.ast;

import java.util.Objects;

public abstract class AstNode {
	protected final int line;
	protected final int col;

	public AstNode (int line, int col) {
		this.line = line;
		this.col = col;
	}

	public int getLine () {
		return line;
	}

	public int getCol () {
		return col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(line, col);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final AstNode other = (AstNode) obj;
		return Objects.equals(this.line, other.line) && Objects.equals(this.col, other.col);
	}
}
