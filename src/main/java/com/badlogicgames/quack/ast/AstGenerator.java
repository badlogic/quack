package com.badlogicgames.quack.ast;

import com.badlogicgames.quack.parsing.antlr.QuackListener;
import com.badlogicgames.quack.parsing.antlr.QuackParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class AstGenerator implements QuackListener {
    private AstCompilationUnit cu;
    private Map<ParserRuleContext, Object> lookup = new HashMap<>();

    public AstCompilationUnit getCompilationUnit() {
        return cu;
    }

    @Override
    public void enterArgument(@NotNull QuackParser.ArgumentContext ctx) {

    }

    @Override
    public void exitArgument(@NotNull QuackParser.ArgumentContext ctx) {
        AstArgument arg = new AstArgument(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        arg.setName(ctx.Identifier().getText());
        arg.setType((AstType) lookup.get(ctx.type()));
        arg.setDefaultValue((AstExpression) lookup.get(ctx.expression()));
        lookup.put(ctx, arg);
    }

    @Override
    public void enterConstant(@NotNull QuackParser.ConstantContext ctx) {

    }

    @Override
    public void exitConstant(@NotNull QuackParser.ConstantContext ctx) {

    }

    @Override
    public void enterWhileBlock(@NotNull QuackParser.WhileBlockContext ctx) {

    }

    @Override
    public void exitWhileBlock(@NotNull QuackParser.WhileBlockContext ctx) {

    }

    @Override
    public void enterModuleName(@NotNull QuackParser.ModuleNameContext ctx) {

    }

    @Override
    public void exitModuleName(@NotNull QuackParser.ModuleNameContext ctx) {

    }

    @Override
    public void enterForBottom(@NotNull QuackParser.ForBottomContext ctx) {

    }

    @Override
    public void exitForBottom(@NotNull QuackParser.ForBottomContext ctx) {

    }

    @Override
    public void enterType(@NotNull QuackParser.TypeContext ctx) {

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
    public void enterStructDefinition(@NotNull QuackParser.StructDefinitionContext ctx) {

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
    public void enterGenericTypeList(@NotNull QuackParser.GenericTypeListContext ctx) {

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
    public void enterArgumentList(@NotNull QuackParser.ArgumentListContext ctx) {

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
    public void enterStatementList(@NotNull QuackParser.StatementListContext ctx) {

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
    public void enterStatement(@NotNull QuackParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(@NotNull QuackParser.StatementContext ctx) {

    }

    @Override
    public void enterForInitializer(@NotNull QuackParser.ForInitializerContext ctx) {

    }

    @Override
    public void exitForInitializer(@NotNull QuackParser.ForInitializerContext ctx) {

    }

    @Override
    public void enterArgumentExpressionList(@NotNull QuackParser.ArgumentExpressionListContext ctx) {

    }

    @Override
    public void exitArgumentExpressionList(@NotNull QuackParser.ArgumentExpressionListContext ctx) {

    }

    @Override
    public void enterBlock(@NotNull QuackParser.BlockContext ctx) {

    }

    @Override
    public void exitBlock(@NotNull QuackParser.BlockContext ctx) {

    }

    @Override
    public void enterImportDeclaration(@NotNull QuackParser.ImportDeclarationContext ctx) {

    }

    @Override
    public void exitImportDeclaration(@NotNull QuackParser.ImportDeclarationContext ctx) {
        AstImport imp = new AstImport(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        StringBuffer buffer = new StringBuffer();
        buffer.append(ctx.moduleName().Identifier(0));
        for(int i = 1; i < ctx.moduleName().Identifier().size(); i++) {
            buffer.append(".");
            buffer.append(ctx.moduleName().Identifier(i).getText());
        }
        imp.setName(buffer.toString());
        lookup.put(ctx, imp);
    }

    @Override
    public void enterGenericParameters(@NotNull QuackParser.GenericParametersContext ctx) {

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
    public void enterUnaryExpression(@NotNull QuackParser.UnaryExpressionContext ctx) {

    }

    @Override
    public void exitUnaryExpression(@NotNull QuackParser.UnaryExpressionContext ctx) {

    }

    @Override
    public void enterIfBlock(@NotNull QuackParser.IfBlockContext ctx) {

    }

    @Override
    public void exitIfBlock(@NotNull QuackParser.IfBlockContext ctx) {

    }

    @Override
    public void enterElseIfBlock(@NotNull QuackParser.ElseIfBlockContext ctx) {

    }

    @Override
    public void exitElseIfBlock(@NotNull QuackParser.ElseIfBlockContext ctx) {

    }

    @Override
    public void enterExpression(@NotNull QuackParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(@NotNull QuackParser.ExpressionContext ctx) {

    }

    @Override
    public void enterFunctionDefinition(@NotNull QuackParser.FunctionDefinitionContext ctx) {

    }

    @Override
    public void exitFunctionDefinition(@NotNull QuackParser.FunctionDefinitionContext ctx) {
        AstFunction func = new AstFunction(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        func.setName(ctx.name.getText());
        if(ctx.genericParameters() != null) {
            func.getGenericTypes().addAll((Collection<? extends String>) lookup.get(ctx.genericParameters()));
        }
        func.getArguments().addAll((Collection<? extends AstArgument>) lookup.get(ctx.argumentList()));
        func.setReturnType((AstType) lookup.get(ctx.type()));
        func.getBody().addAll((Collection<? extends AstStatement>) lookup.get(ctx.statementList()));
        lookup.put(ctx, func);
    }

    @Override
    public void enterForBlock(@NotNull QuackParser.ForBlockContext ctx) {

    }

    @Override
    public void exitForBlock(@NotNull QuackParser.ForBlockContext ctx) {

    }

    @Override
    public void enterModuleDeclaration(@NotNull QuackParser.ModuleDeclarationContext ctx) {

    }

    @Override
    public void exitModuleDeclaration(@NotNull QuackParser.ModuleDeclarationContext ctx) {
        AstModule module = new AstModule(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        StringBuffer buffer = new StringBuffer();
        buffer.append(ctx.moduleName().Identifier(0));
        for(int i = 1; i < ctx.moduleName().Identifier().size(); i++) {
            buffer.append(".");
            buffer.append(ctx.moduleName().Identifier(i).getText());
        }
        module.setName(buffer.toString());
        lookup.put(ctx, module);
    }

    @Override
    public void enterVariableDeclaration(@NotNull QuackParser.VariableDeclarationContext ctx) {

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
    public void enterArgumentExpression(@NotNull QuackParser.ArgumentExpressionContext ctx) {

    }

    @Override
    public void exitArgumentExpression(@NotNull QuackParser.ArgumentExpressionContext ctx) {

    }

    @Override
    public void enterCompilationUnit(@NotNull QuackParser.CompilationUnitContext ctx) {
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
    public void enterReturnExpression(@NotNull QuackParser.ReturnExpressionContext ctx) {

    }

    @Override
    public void exitReturnExpression(@NotNull QuackParser.ReturnExpressionContext ctx) {

    }

    @Override
    public void enterAssignmentOrExpression(@NotNull QuackParser.AssignmentOrExpressionContext ctx) {

    }

    @Override
    public void exitAssignmentOrExpression(@NotNull QuackParser.AssignmentOrExpressionContext ctx) {

    }

    @Override
    public void enterPrimary(@NotNull QuackParser.PrimaryContext ctx) {

    }

    @Override
    public void exitPrimary(@NotNull QuackParser.PrimaryContext ctx) {

    }

    @Override
    public void visitTerminal(@NotNull TerminalNode node) {

    }

    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {

    }

    @Override
    public void enterEveryRule(@NotNull ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(@NotNull ParserRuleContext ctx) {

    }
}
