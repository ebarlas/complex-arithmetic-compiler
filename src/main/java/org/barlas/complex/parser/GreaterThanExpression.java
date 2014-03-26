package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class GreaterThanExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public GreaterThanExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void preAnalyze(Context context) {
        left.preAnalyze(context);
        right.preAnalyze(context);
    }

    @Override
    public void postAnalyze(Context context) {
        left.postAnalyze(context);
        right.postAnalyze(context);
    }

    @Override
    public Complex evaluate(Context context) {
        return left.evaluate(context).re() > right.evaluate(context).re() ? Constants.TRUE : Constants.FALSE;
    }
}
