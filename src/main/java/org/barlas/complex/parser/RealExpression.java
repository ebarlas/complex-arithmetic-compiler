package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class RealExpression implements Expression {

    private final Complex value;

    public RealExpression(double value) {
        this.value = new Complex(value);
    }

    public Complex evaluate(Context context) {
        return value;
    }
}
