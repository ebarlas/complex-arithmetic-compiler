package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class SubtractExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).sub(right.evaluate(context));
    }

}
