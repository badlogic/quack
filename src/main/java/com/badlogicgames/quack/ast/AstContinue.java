package com.badlogicgames.quack.ast;

public class AstContinue extends AstStatement {
    public AstContinue(int line, int col) {
        super(line, col);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return super.equals(obj);
    }
}
