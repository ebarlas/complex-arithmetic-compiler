package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class PowerExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public PowerExpression(Expression left, Expression right) {
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
        Complex base = left.evaluate(context);
        Complex exp = right.evaluate(context);
        return base.im() == 0.0 && exp.im() == 0.0 ? new Complex(Math.pow(base.re(), exp.re())) : base.pow(exp);
    }

}
