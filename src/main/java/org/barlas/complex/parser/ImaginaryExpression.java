package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ImaginaryExpression implements Expression {

    private final Complex value;

    public ImaginaryExpression(double value) {
        this.value = new Complex(0, value);
    }

    public Complex evaluate(Context context) {
        return value;
    }
}
