package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class LessThanExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public LessThanExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).re() < right.evaluate(context).re() ? Constants.TRUE : Constants.FALSE;
    }
}