package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NotEqualsExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public NotEqualsExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        Complex a = left.evaluate(context);
        Complex b = right.evaluate(context);
        return a.re() != b.re() || a.im() != b.im() ? Constants.TRUE : Constants.FALSE;
    }

}
