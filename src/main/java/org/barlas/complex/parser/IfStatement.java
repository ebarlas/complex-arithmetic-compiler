package org.barlas.complex.parser;

public class IfStatement implements Statement {

    private final Expression condition;
    private final Statement statement;

    public IfStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void preAnalyze(Context context) {
        condition.preAnalyze(context);
        statement.preAnalyze(context);
    }

    @Override
    public void postAnalyze(Context context) {
        condition.postAnalyze(context);
        statement.postAnalyze(context);
    }

    @Override
    public void evaluate(Context context) {
        if(condition.evaluate(context).re() != 0.0) {
            statement.evaluate(context);
        }
    }

}
