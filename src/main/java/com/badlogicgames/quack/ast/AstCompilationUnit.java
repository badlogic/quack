
package com.badlogicgames.quack.ast;

import java.util.ArrayList;
import java.util.List;

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
}
