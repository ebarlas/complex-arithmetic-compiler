package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ModExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public ModExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Complex evaluate(Context context) {
        return new Complex(left.evaluate(context).re() % right.evaluate(context).re());
    }

}
