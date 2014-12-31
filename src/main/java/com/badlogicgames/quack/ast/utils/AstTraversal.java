package com.badlogicgames.quack.ast.utils;

import java.util.HashSet;
import java.util.Set;

import com.badlogicgames.quack.ast.AstArgument;
import com.badlogicgames.quack.ast.AstArgumentExpression;
import com.badlogicgames.quack.ast.AstArrayLookup;
import com.badlogicgames.quack.ast.AstBinaryOp;
import com.badlogicgames.quack.ast.AstBlock;
import com.badlogicgames.quack.ast.AstCall;
import com.badlogicgames.quack.ast.AstCast;
import com.badlogicgames.quack.ast.AstCompilationUnit;
import com.badlogicgames.quack.ast.AstElif;
import com.badlogicgames.quack.ast.AstExpression;
import com.badlogicgames.quack.ast.AstFor;
import com.badlogicgames.quack.ast.AstFunction;
import com.badlogicgames.quack.ast.AstGetElement;
import com.badlogicgames.quack.ast.AstIf;
import com.badlogicgames.quack.ast.AstImport;
import com.badlogicgames.quack.ast.AstLiteral;
import com.badlogicgames.quack.ast.AstModule;
import com.badlogicgames.quack.ast.AstNode;
import com.badlogicgames.quack.ast.AstReference;
import com.badlogicgames.quack.ast.AstReturn;
import com.badlogicgames.quack.ast.AstStatement;
import com.badlogicgames.quack.ast.AstStruct;
import com.badlogicgames.quack.ast.AstType;
import com.badlogicgames.quack.ast.AstUnaryOp;
import com.badlogicgames.quack.ast.AstVariableDeclaration;
import com.badlogicgames.quack.ast.AstWhile;

/**
 * Traverses the graph, calls optional callback. Traversal is performed
 * depth first.
 * @author badlogic
 *
 */
public class AstTraversal {
	public static interface AstVisitor {
		public void visit(AstNode parent, AstNode node);
	}
	
	public static void walk(AstVisitor visitor, AstNode node) {
		Set<Class<? extends AstNode>> excluded = new HashSet<>();
		walk(visitor, node, excluded);
	}
	
	public static void walk(AstVisitor visitor, AstNode node, Set<Class<? extends AstNode>> excluded) {
		walk(visitor, null, node, excluded);
	}
	
	private static void walk(AstVisitor visitor, AstNode parent, AstNode node, Set<Class<? extends AstNode>> excluded) {
		if(node == null || excluded.contains(node.getClass())) {
			return;
		}
		
		// visit the node itself
		visitor.visit(parent, node);
		
		// visit any children
		if(node instanceof AstArgument) {
			walk(visitor, node, ((AstArgument)node).getType(), excluded);
			walk(visitor, node, ((AstArgument)node).getDefaultValue(), excluded);			
		} else if(node instanceof AstArgumentExpression) {
			walk(visitor, node, ((AstArgumentExpression)node).getExpression(), excluded);
		} else if(node instanceof AstArrayLookup) {		
			walk(visitor, node, ((AstArrayLookup)node).getArray(), excluded);
			walk(visitor, node, ((AstArrayLookup)node).getIndex(), excluded);
		} else if(node instanceof AstBinaryOp) {
			walk(visitor, node, ((AstBinaryOp)node).getLeftHandSide(), excluded);
			walk(visitor, node, ((AstBinaryOp)node).getRightHandSide(), excluded);
		} else if(node instanceof AstBlock) {
			for(AstStatement stmt: ((AstBlock)node).getStatements()) {
				walk(visitor, node, stmt, excluded);
			}
		} else if(node instanceof AstCall) {
			walk(visitor, node, ((AstCall)node).getTarget(), excluded);
			for(AstType generic: ((AstCall)node).getGenericTypes()) {
				walk(visitor, node, generic, excluded);				
			}
			for(AstExpression expr: ((AstCall)node).getArguments()) {
				walk(visitor, node, expr, excluded);
			}
		} else if(node instanceof AstCast) {
			walk(visitor, node, ((AstCast)node).getType(), excluded);
			walk(visitor, node, ((AstCast)node).getExpression(), excluded);
		}else if(node instanceof AstCompilationUnit) {
			walk(visitor, node, ((AstCompilationUnit)node).getModule(), excluded);
			for(AstImport imp: ((AstCompilationUnit)node).getImports()) {
				walk(visitor, node, imp, excluded);
			}
			for(AstFunction fun: ((AstCompilationUnit)node).getFunctions()) {
				walk(visitor, node, fun, excluded);
			}
			for(AstStruct struct: ((AstCompilationUnit)node).getStructs()) {
				walk(visitor, node, struct, excluded);
			}
		} else if(node instanceof AstElif) {
			walk(visitor, node, ((AstElif)node).getCondition(), excluded);
			walk(visitor, node, ((AstElif)node).getBlock(), excluded);
		} else if(node instanceof AstFor) {
			for(AstStatement stmt: ((AstFor)node).getInitializers()) {
				walk(visitor, node, stmt, excluded);
			}
			walk(visitor, node, ((AstFor)node).getCondition(), excluded);
			for(AstStatement stmt: ((AstFor)node).getBottom()) {
				walk(visitor, node, stmt, excluded);
			}
			walk(visitor, node, ((AstFor)node).getBlock(), excluded);
		} else if(node instanceof AstFunction) {
			for(AstArgument arg: ((AstFunction)node).getArguments()) {
				walk(visitor, node, arg, excluded);
			}
			walk(visitor, node, ((AstFunction)node).getReturnType(), excluded);
			for(AstStatement stmt: ((AstFunction)node).getBody()) {
				walk(visitor, node, stmt, excluded);
			}
		} else if(node instanceof AstGetElement) {
			walk(visitor, node, ((AstGetElement)node).getTarget(), excluded);
			walk(visitor, node, ((AstGetElement)node).getElement(), excluded);
		} else if(node instanceof AstIf) {
			walk(visitor, node, ((AstIf)node).getCondition(), excluded);
			walk(visitor, node, ((AstIf)node).getTrueBlock(), excluded);
			for(AstElif elif: ((AstIf)node).getElseIfs()) {
				walk(visitor, node, elif, excluded);
			}
			walk(visitor, node, ((AstIf)node).getElseBlock(), excluded);
		} else if(node instanceof AstImport) {
			// nothing to do here
		} else if(node instanceof AstLiteral) {
			// nothing to do here
		} else if(node instanceof AstModule) {
			// nothing to do here
		} else if(node instanceof AstReference) {
			// nothing to do here
		} else if(node instanceof AstReturn) {
			walk(visitor, node, ((AstReturn)node).getValue(), excluded);
		} else if(node instanceof AstStruct) { 
			for(AstVariableDeclaration field: ((AstStruct)node).getFields()) {
				walk(visitor, node, field, excluded);
			}
			for(AstFunction fun: ((AstStruct)node).getFunctions()) {
				walk(visitor, node, fun, excluded);
			}
		} else if(node instanceof AstType) {
			for(AstType generic: ((AstType)node).getGenericTypes()) {
				walk(visitor, node, generic, excluded);
			}
			for(AstArgument arg: ((AstType)node).getArguments()) {
				walk(visitor, node, arg, excluded);
			}
			walk(visitor, node, ((AstType)node).getReturnType(), excluded);
		} else if(node instanceof AstUnaryOp) {
			walk(visitor, node, ((AstUnaryOp)node).getExpression(), excluded);
		} else if(node instanceof AstVariableDeclaration) {
			walk(visitor, node, ((AstVariableDeclaration)node).getType(), excluded);
			walk(visitor, node, ((AstVariableDeclaration)node).getInitializer(), excluded);
		} else if(node instanceof AstWhile) {
			walk(visitor, node, ((AstWhile)node).getCondition(), excluded);
			walk(visitor, node, ((AstWhile)node).getBlock(), excluded);
		}
	}
}
