package org.barlas.complex.parser;

public class IfStatement implements Statement {

    private final Expression condition;
    private final Statement statement;

    public IfStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    public void evaluate(Context context) {
        if(condition.evaluate(context).re() != 0.0) {
            statement.evaluate(context);
        }
    }

}
