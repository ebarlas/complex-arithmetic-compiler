package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NegateExpression extends AbstractNode implements Expression {

    private final Expression expression;

    public NegateExpression(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public Complex evaluate() {
        return new Complex(expression.evaluate().neg());
    }

}
