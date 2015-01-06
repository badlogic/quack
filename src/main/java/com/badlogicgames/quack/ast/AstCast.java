package com.badlogicgames.quack.ast;

public class AstCast extends AstExpression {
    private AstType type;
    private AstExpression expression;

    public AstCast (int line, int col) {
        super(line, col);
    }

    public AstType getType () {
        return type;
    }

    public void setType (AstType type) {
        this.type = type;
    }

    public AstExpression getExpression () {
        return expression;
    }

    public void setExpression (AstExpression expression) {
        this.expression = expression;
    }
}
