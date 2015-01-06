package com.badlogicgames.quack.ast;

import java.util.Objects;

public class AstBreak extends AstStatement {
    public AstBreak(int line, int column) {
        super(line, column);
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
