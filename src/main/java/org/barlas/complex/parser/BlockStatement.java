package org.barlas.complex.parser;

import java.util.List;

public class BlockStatement extends AbstractNode implements Statement {

    private final Statement[] statements;

    public BlockStatement(List<Statement> list) {
        super(list.toArray(new Statement[list.size()]));
        this.statements = (Statement[])getChildren();
    }

    @Override
    public void evaluate() {
        for(Statement statement : statements) {
            statement.evaluate();
        }
    }
}
