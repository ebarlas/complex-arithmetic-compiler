package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ImaginaryExpression extends AbstractNode implements Expression {

    private final Complex value;

    public ImaginaryExpression(double value) {
        this.value = new Complex(0, value);
    }

    @Override
    public Complex evaluate() {
        return value;
    }
}
