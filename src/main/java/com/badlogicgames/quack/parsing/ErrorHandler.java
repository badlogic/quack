package com.badlogicgames.quack.parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Parser;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler extends BailErrorStrategy {
    private final List<RecognitionException> errors = new ArrayList<>();

    public List<RecognitionException> getErrors() {
        return errors;
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        super.reportError(recognizer, e);
        errors.add(e);
    }
}
