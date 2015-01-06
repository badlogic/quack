package com.badlogicgames.quack.ast;

import com.badlogicgames.quack.parsing.QuackAdapter;
import com.badlogicgames.quack.parsing.antlr.QuackParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class AstGenerator extends QuackAdapter {
    private AstCompilationUnit cu;
    private Map<ParserRuleContext, Object> lookup = new HashMap<ParserRuleContext, Object>() {
        @Override
        public Object get(Object key) {
            Object result = super.get(key);
            if(result == null) {
                throw new RuntimeException("Couldn't retrieve AST node for: " + key);
            }
            return result;
        }
    };

    public AstCompilationUnit getCompilationUnit() {
        return cu;
    }

    @Override
    public void exitArgument(@NotNull QuackParser.ArgumentContext ctx) {
        AstArgument arg = new AstArgument(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        arg.setName(ctx.Identifier().getText());
        arg.setType((AstType) lookup.get(ctx.type()));
        if(ctx.expression() != null) {
            arg.setDefaultValue((AstExpression) lookup.get(ctx.expression()));
        }
        lookup.put(ctx, arg);
    }

    @Override
    public void exitConstant(@NotNull QuackParser.ConstantContext ctx) {
        AstLiteral lit = new AstLiteral(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        lit.setValue(ctx.getText());
        if(ctx.NullLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.Null);
        } else if(ctx.BooleanLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.Boolean);
        } else if(ctx.IntegerLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.Integer);
        } else if(ctx.FloatingPointLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.Float);
        } else if(ctx.CharacterLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.Character);
        } else if(ctx.StringLiteral() != null) {
            lit.setLiteralType(AstLiteral.LiteralType.String);
        }
        lookup.put(ctx, lit);
    }

    @Override
    public void exitWhileBlock(@NotNull QuackParser.WhileBlockContext ctx) {
        AstWhile whl = new AstWhile(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        whl.setCondition((AstExpression) lookup.get(ctx.expression()));
        whl.setBlock((AstBlock) lookup.get(ctx.block()));
        lookup.put(ctx, whl);
    }

    @Override
    public void exitModuleName(@NotNull QuackParser.ModuleNameContext ctx) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(ctx.Identifier(0));
        for (int i = 1; i < ctx.Identifier().size(); i++) {
            buffer.append(".");
            buffer.append(ctx.Identifier(i).getText());
        }
        lookup.put(ctx, buffer.toString());
    }

    @Override
    public void exitForBottom(@NotNull QuackParser.ForBottomContext ctx) {
        List<AstStatement> stmts = new ArrayList<>();
        for(QuackParser.AssignmentOrExpressionContext s: ctx.assignmentOrExpression()) {
            stmts.add((AstStatement) lookup.get(s));
        }
        lookup.put(ctx, stmts);
    }

    @Override
    public void exitType(@NotNull QuackParser.TypeContext ctx) {
        AstType type = new AstType(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.name != null) {
            type.setName(ctx.name.getText());
        }
        if(ctx.genericTypeList() != null) {
            type.getGenericTypes().addAll((Collection<? extends AstType>) lookup.get(ctx.genericTypeList()));
        }
        if(ctx.argumentList() != null) {
            type.getArguments().addAll((Collection<? extends AstArgument>) lookup.get(ctx.argumentList()));
        }
        if(ctx.type() != null) {
            type.setReturnType((AstType) lookup.get(ctx.type()));
        }
        lookup.put(ctx, type);
    }

    @Override
    public void exitStructDefinition(@NotNull QuackParser.StructDefinitionContext ctx) {
        AstStruct struct = new AstStruct(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        struct.setName(ctx.name.getText());
        if(ctx.genericParameters() != null) {
            for (TerminalNode id : ctx.genericParameters().Identifier()) {
                struct.getGenericTypes().add(id.getText());
            }
        }
        if(ctx.variableDeclaration() != null) {
            for(QuackParser.VariableDeclarationContext v: ctx.variableDeclaration()) {
                struct.getFields().add((AstVariableDeclaration) lookup.get(v));
            }
        }
        if(ctx.functionDefinition() != null) {
            for(QuackParser.FunctionDefinitionContext f: ctx.functionDefinition()) {
                struct.getFunctions().add((AstFunction) lookup.get(f));
            }
        }
        lookup.put(ctx, struct);
    }

    @Override
    public void exitGenericTypeList(@NotNull QuackParser.GenericTypeListContext ctx) {
        List<AstType> genericTypes = new ArrayList<>();
        for(QuackParser.TypeContext t: ctx.type()) {
            genericTypes.add((AstType) lookup.get(t));
        }
        lookup.put(ctx, genericTypes);
    }

    @Override
    public void exitArgumentList(@NotNull QuackParser.ArgumentListContext ctx) {
        List<AstArgument> args = new ArrayList<>();
        for(QuackParser.ArgumentContext a: ctx.argument()) {
            args.add((AstArgument) lookup.get(a));
        }
        lookup.put(ctx, args);
    }

    @Override
    public void exitStatementList(@NotNull QuackParser.StatementListContext ctx) {
        List<AstStatement> stmts = new ArrayList<>();
        if(ctx.statement() != null) {
            for(QuackParser.StatementContext s: ctx.statement()) {
                stmts.add((AstStatement) lookup.get(s));
            }
        }
        lookup.put(ctx, stmts);
    }

    @Override
    public void exitStatement(@NotNull QuackParser.StatementContext ctx) {
        if(ctx.variableDeclaration() != null) {
            lookup.put(ctx, lookup.get(ctx.variableDeclaration()));
        } else if(ctx.block() != null) {
            lookup.put(ctx, lookup.get(ctx.block()));
        } else if(ctx.ifBlock() != null) {
            lookup.put(ctx, lookup.get(ctx.ifBlock()));
        } else if(ctx.whileBlock() != null) {
            lookup.put(ctx, lookup.get(ctx.whileBlock()));
        } else if(ctx.forBlock() != null) {
            lookup.put(ctx, lookup.get(ctx.forBlock()));
        } else if(ctx.returnExpression() != null) {
            lookup.put(ctx, lookup.get(ctx.returnExpression()));
        } else if(ctx.assignmentOrExpression() != null) {
            lookup.put(ctx, lookup.get(ctx.assignmentOrExpression()));
        } else if(ctx.cont != null) {
            AstContinue cont = new AstContinue(ctx.cont.getLine(), ctx.cont.getCharPositionInLine());
            lookup.put(ctx, cont);
        } else if(ctx.brk != null) {
            AstBreak brk = new AstBreak(ctx.brk.getLine(), ctx.brk.getCharPositionInLine());
            lookup.put(ctx, brk);
        } else {
            throw new RuntimeException("Unknown statement: " + ctx.getText());
        }
    }

    @Override
    public void exitForInitializer(@NotNull QuackParser.ForInitializerContext ctx) {
        List<AstVariableDeclaration> decls = new ArrayList<>();
        for(QuackParser.VariableDeclarationContext v: ctx.variableDeclaration()) {
            decls.add((AstVariableDeclaration) lookup.get(v));
        }
        lookup.put(ctx, decls);
    }

    @Override
    public void exitArgumentExpressionList(@NotNull QuackParser.ArgumentExpressionListContext ctx) {
        List<AstExpression> args = new ArrayList<>();
        for(QuackParser.ArgumentExpressionContext e: ctx.argumentExpression()) {
            args.add((AstExpression) lookup.get(e));
        }
        lookup.put(ctx, args);
    }

    @Override
    public void exitBlock(@NotNull QuackParser.BlockContext ctx) {
        AstBlock block = new AstBlock(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        block.getStatements().addAll((Collection<? extends AstStatement>) lookup.get(ctx.statementList()));
        lookup.put(ctx, block);
    }

    @Override
    public void exitImportDeclaration(@NotNull QuackParser.ImportDeclarationContext ctx) {
        AstImport imp = new AstImport(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        imp.setName((String) lookup.get(ctx.moduleName()));
        lookup.put(ctx, imp);
    }

    @Override
    public void exitGenericParameters(@NotNull QuackParser.GenericParametersContext ctx) {
        List<String> params = new ArrayList<>();
        for(TerminalNode p: ctx.Identifier()) {
            params.add(p.getText());
        }
        lookup.put(ctx, params);
    }

    @Override
    public void exitUnaryExpression(@NotNull QuackParser.UnaryExpressionContext ctx) {
        if(ctx.primary() != null) {
            lookup.put(ctx, lookup.get(ctx.primary()));
        } else {
            AstUnaryOp unary = new AstUnaryOp(ctx.start.getLine(), ctx.start.getCharPositionInLine());
            unary.setOperator(ctx.op.getText());
            unary.setExpression((AstExpression) lookup.get(ctx.unaryExpression()));
            lookup.put(ctx, unary);
        }

    }

    @Override
    public void exitUnary(@NotNull QuackParser.UnaryContext ctx) {
        lookup.put(ctx, lookup.get(ctx.unaryExpression()));
    }

    @Override
    public void exitIfBlock(@NotNull QuackParser.IfBlockContext ctx) {
        AstIf ifBlock = new AstIf(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        ifBlock.setCondition((AstExpression) lookup.get(ctx.expression()));
        ifBlock.setTrueBlock((AstBlock) lookup.get(ctx.tb));
        if(ctx.elseIfBlock() != null) {
            for(QuackParser.ElseIfBlockContext el: ctx.elseIfBlock()) {
                ifBlock.getElseIfs().add((AstElif) lookup.get(el));
            }
        }
        if(ctx.eb != null) {
            ifBlock.setElseBlock((AstBlock) lookup.get(ctx.eb));
        }
        lookup.put(ctx, ifBlock);
    }

    @Override
    public void exitElseIfBlock(@NotNull QuackParser.ElseIfBlockContext ctx) {
        AstElif elif = new AstElif(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        elif.setCondition((AstExpression) lookup.get(ctx.expression()));
        elif.setBlock((AstBlock) lookup.get(ctx.block()));
        lookup.put(ctx, elif);
    }

    @Override
    public void exitDereference(@NotNull QuackParser.DereferenceContext ctx) {
        AstDereference deref = new AstDereference(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        deref.setTarget((AstExpression) lookup.get(ctx.expression(0)));
        deref.setElement((AstReference) lookup.get(ctx.expression(1)));
        lookup.put(ctx, deref);
    }

    @Override
    public void exitAnonymousFunction(@NotNull QuackParser.AnonymousFunctionContext ctx) {
        AstAnonymousFunction fun = new AstAnonymousFunction(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.genericParameters() != null) {
            fun.getGenericParameters().addAll((Collection<? extends String>) lookup.get(ctx.genericParameters()));
        }
        fun.getArguments().addAll((Collection<? extends AstArgument>) lookup.get(ctx.argumentList()));
        if(ctx.type() != null) {
            fun.setReturnType((AstType) lookup.get(ctx.type()));
        }
        fun.getBody().addAll((Collection<? extends AstStatement>) lookup.get(ctx.statementList()));
        lookup.put(ctx, fun);
    }

    @Override
    public void exitCall(@NotNull QuackParser.CallContext ctx) {
        AstCall call = new AstCall(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        call.setTarget((AstExpression) lookup.get(ctx.expression()));
        if(ctx.genericTypeList() != null) {
            call.getGenericTypes().addAll((Collection<? extends AstType>) lookup.get(ctx.genericTypeList()));
        }
        if(ctx.argumentExpressionList() != null) {
            call.getArguments().addAll((Collection<? extends AstExpression>) lookup.get(ctx.argumentExpressionList()));
        }
        lookup.put(ctx, call);
    }

    @Override
    public void exitArrayAccess(@NotNull QuackParser.ArrayAccessContext ctx) {
        AstArrayAccess arrayAccess = new AstArrayAccess(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        arrayAccess.setArray((AstExpression) lookup.get(ctx.expression(0)));
        arrayAccess.setIndex((AstExpression) lookup.get(ctx.expression(1)));
        lookup.put(ctx, arrayAccess);
    }

    @Override
    public void exitCast(@NotNull QuackParser.CastContext ctx) {
        AstCast cast = new AstCast(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        cast.setType((AstType) lookup.get(ctx.type()));
        cast.setExpression((AstExpression) lookup.get(ctx.expression()));
        lookup.put(ctx, cast);
    }

    @Override
    public void exitBinaryOp(@NotNull QuackParser.BinaryOpContext ctx) {
        AstBinaryOp binaryOp = new AstBinaryOp(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        binaryOp.setLeftHandSide((AstExpression) lookup.get(ctx.expression(0)));
        if(ctx.shl() != null) {
            binaryOp.setOperator("<<");
        } else if(ctx.shr() != null) {
            binaryOp.setOperator(">>");
        } else {
            binaryOp.setOperator(ctx.op.getText());
        }
        binaryOp.setLeftHandSide((AstExpression) lookup.get(ctx.expression(1)));
        lookup.put(ctx, binaryOp);
    }

    @Override
    public void exitFunctionDefinition(@NotNull QuackParser.FunctionDefinitionContext ctx) {
        AstFunction func = new AstFunction(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        func.setName(ctx.name.getText());
        if(ctx.genericParameters() != null) {
            func.getGenericParameters().addAll((Collection<? extends String>) lookup.get(ctx.genericParameters()));
        }
        func.getArguments().addAll((Collection<? extends AstArgument>) lookup.get(ctx.argumentList()));
        if(ctx.type() != null) {
            func.setReturnType((AstType) lookup.get(ctx.type()));
        }
        func.getBody().addAll((Collection<? extends AstStatement>) lookup.get(ctx.statementList()));
        lookup.put(ctx, func);
    }

    @Override
    public void exitForBlock(@NotNull QuackParser.ForBlockContext ctx) {
        AstFor forBlock = new AstFor(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.forInitializer() != null) {
            forBlock.getInitializers().addAll((Collection<? extends AstStatement>) lookup.get(ctx.forInitializer()));
        }
        forBlock.setCondition((AstExpression) lookup.get(ctx.expression()));
        if(ctx.forBottom() != null) {
            forBlock.getBottom().addAll((Collection<? extends AstStatement>) lookup.get(ctx.forBottom()));
        }
        lookup.put(ctx, forBlock);
    }

    @Override
    public void exitModuleDeclaration(@NotNull QuackParser.ModuleDeclarationContext ctx) {
        AstModule module = new AstModule(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        module.setName((String) lookup.get(ctx.moduleName()));
        lookup.put(ctx, module);
    }

    @Override
    public void exitVariableDeclaration(@NotNull QuackParser.VariableDeclarationContext ctx) {
        AstVariableDeclaration var = new AstVariableDeclaration(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.qualifier.getText().equals("val")) {
            var.setQualifier(AstVariableDeclaration.Qualifier.Val);
        } else if(ctx.qualifier.getText().equals("var")) {
            var.setQualifier(AstVariableDeclaration.Qualifier.Var);
        } else {
            throw new RuntimeException("Unknown qualifier: " + ctx.qualifier.getText());
        }
        var.setName(ctx.name.getText());
        if(ctx.type() != null) {
            var.setType((AstType) lookup.get(ctx.type()));
        }
        if(ctx.expression() != null) {
            var.setInitializer((AstExpression) lookup.get(ctx.expression()));
        }
        lookup.put(ctx, var);
    }

    @Override
    public void exitArgumentExpression(@NotNull QuackParser.ArgumentExpressionContext ctx) {
        AstArgumentExpression arg = new AstArgumentExpression(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.Identifier() != null) {
            arg.setArgumentName(ctx.Identifier().getText());
        }
        arg.setExpression((AstExpression) lookup.get(ctx.expression()));
        lookup.put(ctx, arg);
    }

    @Override
    public void exitCompilationUnit(@NotNull QuackParser.CompilationUnitContext ctx) {
        cu = new AstCompilationUnit(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        cu.setModule((AstModule) lookup.get(ctx.moduleDeclaration()));
        if (ctx.importDeclaration() != null) {
            for (QuackParser.ImportDeclarationContext i : ctx.importDeclaration()) {
                cu.getImports().add((AstImport) lookup.get(i));
            }
        }
        if (ctx.structDefinition() != null) {
            for (QuackParser.StructDefinitionContext s : ctx.structDefinition()) {
                cu.getStructs().add((AstStruct) lookup.get(s));
            }
        }
        if (ctx.functionDefinition() != null) {
            for (QuackParser.FunctionDefinitionContext f : ctx.functionDefinition()) {
                cu.getFunctions().add((AstFunction) lookup.get(f));
            }
        }
    }

    @Override
    public void exitReturnExpression(@NotNull QuackParser.ReturnExpressionContext ctx) {
        AstReturn ret = new AstReturn(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if(ctx.expression() != null) {
            ret.setValue((AstExpression) lookup.get(ctx.expression()));
        }
        lookup.put(ctx, ret);
    }

    @Override
    public void exitAssignmentOrExpression(@NotNull QuackParser.AssignmentOrExpressionContext ctx) {
        if(ctx.expression().size() == 2) {
            AstBinaryOp assign = new AstBinaryOp(ctx.start.getLine(), ctx.start.getCharPositionInLine());
            assign.setOperator("=");
            assign.setLeftHandSide((AstExpression) lookup.get(ctx.expression(0)));
            assign.setRightHandSide((AstExpression) lookup.get(ctx.expression(1)));
            lookup.put(ctx, assign);
        } else {
            lookup.put(ctx, lookup.get(ctx.expression(0)));
        }
    }

    @Override
    public void exitPrimary(@NotNull QuackParser.PrimaryContext ctx) {
        if(ctx.Identifier() != null) {
            AstReference ref = new AstReference(ctx.start.getLine(), ctx.start.getCharPositionInLine());
            ref.setName(ctx.Identifier().getText());
            lookup.put(ctx, ref);
        } else if(ctx.constant() != null) {
            lookup.put(ctx, lookup.get(ctx.constant()));
        } else {
            lookup.put(ctx, lookup.get(ctx.expression()));
        }
    }
}
