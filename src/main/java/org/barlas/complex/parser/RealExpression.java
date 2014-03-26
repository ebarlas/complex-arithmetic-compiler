package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class RealExpression implements Expression {

    private final Complex value;

    public RealExpression(double value) {
        this.value = new Complex(value);
    }

    @Override
    public void preAnalyze(Context context) {}

    @Override
    public void postAnalyze(Context context) {}

    @Override
    public Complex evaluate(Context context) {
        return value;
    }
}
