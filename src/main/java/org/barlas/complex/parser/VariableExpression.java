package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class VariableExpression implements Expression {

    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    public Complex evaluate(Context context) {
        Complex c = context.get(name);
        return c == null ? Constants.ZERO : c;
    }
}
