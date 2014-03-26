package org.barlas.complex.parser;

import java.util.List;

public class BlockStatement implements Statement {

    private final Statement[] statements;

    public BlockStatement(List<Statement> list) {
        this.statements = list.toArray(new Statement[list.size()]);
    }

    @Override
    public void preAnalyze(Context context) {
        for(Statement statement : statements) {
            statement.preAnalyze(context);
        }
    }

    @Override
    public void postAnalyze(Context context) {
        for(Statement statement : statements) {
            statement.postAnalyze(context);
        }
    }

    @Override
    public void evaluate(Context context) {
        for(Statement statement : statements) {
            statement.evaluate(context);
        }
    }
}
