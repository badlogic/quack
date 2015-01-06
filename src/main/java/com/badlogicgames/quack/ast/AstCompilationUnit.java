
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AstCompilationUnit extends AstNode {
	private AstModule module;
	private final List<AstImport> imports = new ArrayList<>();
	private final List<AstStruct> structs = new ArrayList<>();
	private final List<AstFunction> functions = new ArrayList<>();

	public AstCompilationUnit (int line, int col) {
		super(line, col);
	}

	public AstModule getModule () {
		return module;
	}

	public void setModule (AstModule module) {
		this.module = module;
	}

	public List<AstImport> getImports () {
		return imports;
	}

	public List<AstStruct> getStructs () {
		return structs;
	}

	public List<AstFunction> getFunctions () {
		return functions;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(module, imports, structs, functions);
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
		final AstCompilationUnit other = (AstCompilationUnit) obj;
		return Objects.equals(this.module, other.module) && Objects.equals(this.imports, other.imports) && Objects.equals(this.structs, other.structs) && Objects.equals(this.functions, other.functions);
	}
}
