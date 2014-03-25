package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class PowerExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public PowerExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).pow(right.evaluate(context));
    }

}
