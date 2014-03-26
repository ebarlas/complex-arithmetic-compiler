package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ImaginaryExpression implements Expression {

    private final Complex value;

    public ImaginaryExpression(double value) {
        this.value = new Complex(0, value);
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
