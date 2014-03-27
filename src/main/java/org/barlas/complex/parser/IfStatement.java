package org.barlas.complex.parser;

public class IfStatement extends AbstractNode implements Statement {

    private final Expression condition;
    private final Statement statement;

    public IfStatement(Expression condition, Statement statement) {
        super(condition, statement);
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void evaluate() {
        if(condition.evaluate().re() != 0.0) {
            statement.evaluate();
        }
    }

}
