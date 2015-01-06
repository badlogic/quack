package com.badlogicgames.quack.ast;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(type, expression);
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
        final AstCast other = (AstCast) obj;
        return Objects.equals(this.type, other.type) && Objects.equals(this.expression, other.expression);
    }
}
