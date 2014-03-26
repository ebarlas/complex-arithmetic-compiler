package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AbsExpression implements Expression {

    private final Expression expression;

    public AbsExpression(Expression expression) {
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
        return new Complex(expression.evaluate(context).abs());
    }

}
