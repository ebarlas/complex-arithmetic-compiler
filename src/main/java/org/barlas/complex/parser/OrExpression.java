package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class OrExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public OrExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return left.evaluate(context).re() != 0.0 || right.evaluate(context).re() != 0.0 ? Constants.TRUE : Constants.FALSE;
    }

}
