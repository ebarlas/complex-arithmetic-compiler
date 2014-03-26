package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class EqualsExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public EqualsExpression(Expression left, Expression right) {
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
        Complex a = left.evaluate(context);
        Complex b = right.evaluate(context);
        return a.re() == b.re() && a.im() == b.im() ? Constants.TRUE : Constants.FALSE;
    }

}
