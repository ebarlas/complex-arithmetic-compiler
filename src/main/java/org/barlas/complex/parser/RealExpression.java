package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class RealExpression extends AbstractNode implements Expression {

    private final Complex value;

    public RealExpression(double value) {
        this.value = new Complex(value);
    }

    @Override
    public Complex evaluate() {
        return value;
    }
}
