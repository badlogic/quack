package com.badlogicgames.quack.parsing;

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler extends BaseErrorListener {
    public static class Error {
        private final int startLine;
        private final int startColumn;
        private final int endLine;
        private final int endColumn;
        private final String msg;

        public Error(int startLine, int startColumn, int endLine, int endColumn, String msg) {
            this.startLine = startLine;
            this.startColumn = startColumn;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.msg = msg;
        }

        public int getStartLine() {
            return startLine;
        }

        public int getStartColumn() {
            return startColumn;
        }

        public int getEndLine() {
            return endLine;
        }

        public int getEndColumn() {
            return endColumn;
        }

        public String getMsg() {
            return msg;
        }
    }

    private final List<Error> errors = new ArrayList<>();

    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        errors.add(generateError(recognizer, (Token) offendingSymbol, line, charPositionInLine, msg));
    }

    protected Error generateError(Recognizer recognizer,
                                    Token offendingToken, int line,
                                    int charPositionInLine, String msg) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        StringBuffer buffer = new StringBuffer();
        buffer.append("Error [" + line + ":" + charPositionInLine + "]: " + msg + "\n");
        buffer.append(errorLine);
        buffer.append("\n");
        for (int i = 0; i < charPositionInLine; i++) {
            if (errorLine.charAt(i) == '\t') {
                buffer.append("\t");
            } else {
                buffer.append(" ");
            }
        }
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i++) {
                buffer.append("^");
            }
        }
        return new Error(line, charPositionInLine, line, stop, buffer.toString());
    }
}
