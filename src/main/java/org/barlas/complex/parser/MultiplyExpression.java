package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class MultiplyExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).mul(right.evaluate(context));
    }

}
