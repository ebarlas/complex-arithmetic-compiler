package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NotExpression extends AbstractNode implements Expression {

    private final Expression expression;

    public NotExpression(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public Complex evaluate() {
        return expression.evaluate().re() == 0.0 ? Constants.TRUE : Constants.FALSE;
    }

}
