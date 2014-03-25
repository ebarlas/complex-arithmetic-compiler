package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NegateExpression implements Expression {

    private final Expression expression;

    public NegateExpression(Expression expression) {
        this.expression = expression;
    }

    public Complex evaluate(Context context) {
        return new Complex(expression.evaluate(context).neg());
    }

}
