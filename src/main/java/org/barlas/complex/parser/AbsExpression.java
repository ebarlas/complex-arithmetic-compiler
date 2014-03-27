package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AbsExpression extends AbstractNode implements Expression {

    private final Expression expression;

    public AbsExpression(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public Complex evaluate() {
        return new Complex(expression.evaluate().abs());
    }

}
