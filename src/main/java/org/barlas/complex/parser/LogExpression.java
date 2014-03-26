package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class LogExpression implements Expression {

    private final Expression expression;

    public LogExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void preAnalyze(Context context) {
        expression.preAnalyze(context);
    }

    @Override
    public void postAnalyze(Context context) {
        expression.postAnalyze(context);
    }

    @Override
    public Complex evaluate(Context context) {
        return expression.evaluate(context).log();
    }

}
