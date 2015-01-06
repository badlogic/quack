
package com.badlogicgames.quack.ast.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import com.badlogicgames.quack.ast.*;

public class AstGraphViz {
	public static void showGraphViz (AstNode node) {

	}

	public static String buildGraphViz(AstNode node) {
		final AtomicInteger nextId = new AtomicInteger();
		final Map<AstNode, String> nodeIds = new HashMap<>();
		final Map<AstNode, String> nodeLabels = new HashMap<>();
		final List<String> edges = new ArrayList<>();
		
		AstTraversal.walk((p, n) -> {
			String parentId = nodeIds.get(p);
			String nodeId = nodeIds.get(n);
			if(nodeId == null) {
				nodeId = "node" + nextId.incrementAndGet();
				nodeIds.put(n, nodeId);
			}
			nodeLabels.put(n, "[label=\"" + getLabel(n) + "\"]");
			if(parentId != null) {
				edges.add("   " + parentId + " -> " + nodeId + ";\n");
			}
		}, node);
		
		StringBuilder b = new StringBuilder();
		b.append("digraph {\n");
		for(Entry<AstNode, String> entry: nodeIds.entrySet()) {
			b.append("   " + entry.getValue() + " " + nodeLabels.get(entry.getKey()) + ";\n");
		}
		for(String edge: edges) {
			b.append(edge);
		}
		b.append("}\n");
		return b.toString();
	}
	
	private static String getLabel(AstNode node) {
		// visit any children
		if(node instanceof AstAnonymousFunction) {
			return "Anonymous function";
		} else if(node instanceof AstArgument) {
			return " Argument " + ((AstArgument)node).getName() + ": " + ((AstArgument)node).getType().getName();
		} else if(node instanceof AstArgumentExpression) {
			return "Arg. Expr." + (((AstArgumentExpression)node).getArgumentName() !=null?"(" + ((AstArgumentExpression)node).getArgumentName() + ")":"");
		} else if(node instanceof AstArrayAccess) {
			return "[]";
		} else if(node instanceof AstBinaryOp) {
			return ((AstBinaryOp)node).getOperator().name();
		} else if(node instanceof AstBlock) {
			return "Block";
		} else if(node instanceof AstBreak) {
			return "Break";
		} else if(node instanceof AstCall) {
			return "Call";
		} else if(node instanceof AstCompilationUnit) {
			return "Compilation Unit";
		} else if(node instanceof AstContinue) {
			return "Continue";
		} else if(node instanceof AstElif) {
			return "Elif";
		} else if(node instanceof AstFor) {
			return "For";
		} else if(node instanceof AstFunction) {
			return "Def " + ((AstFunction)node).getName();
		} else if(node instanceof AstDereference) {
			return "Get Element";
		} else if(node instanceof AstIf) {
			return "If";
		} else if(node instanceof AstImport) {
			return "Import " + ((AstImport)node).getName();
		} else if(node instanceof AstLiteral) {
			return ((AstLiteral)node).getValue();
		} else if(node instanceof AstModule) {
			return "Module " + ((AstModule)node).getName();
		} else if(node instanceof AstReference) {
			return ((AstReference)node).getName();
		} else if(node instanceof AstReturn) {
			return "Return";
		} else if(node instanceof AstStruct) {
			AstStruct struct = ((AstStruct)node);
			return "Struct " + struct.getName() + (struct.getGenericTypes().size() > 0?" <" + struct.getGenericTypes() + ">":"");
		} else if(node instanceof AstType) {
			return "type: " + ((AstType)node).getName();
		} else if(node instanceof AstUnaryOp) {
			return ((AstUnaryOp)node).getOperator().name();
		} else if(node instanceof AstVariableDeclaration) {
			return (((AstVariableDeclaration)node).isStatic()?"Static ":"") + ((AstVariableDeclaration)node).getQualifier().name() + " " + ((AstVariableDeclaration)node).getName();
		} else if(node instanceof AstWhile) {
			return "While";
		} else {
			throw new RuntimeException("Unknown AST node: " + node.getClass().getName());
		}
	}
}
