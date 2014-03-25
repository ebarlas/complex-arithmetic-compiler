package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AddExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).add(right.evaluate(context));
    }

}
