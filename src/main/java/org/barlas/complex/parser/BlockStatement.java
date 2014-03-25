package org.barlas.complex.parser;

import java.util.List;

public class BlockStatement implements Statement {

    private final Statement[] statements;

    public BlockStatement(List<Statement> list) {
        this.statements = list.toArray(new Statement[list.size()]);
    }

    public void evaluate(Context context) {
        for(Statement statement : statements) {
            statement.evaluate(context);
        }
    }
}
