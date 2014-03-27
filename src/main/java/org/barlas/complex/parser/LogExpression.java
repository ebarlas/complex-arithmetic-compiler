package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class LogExpression extends AbstractNode implements Expression {

    private final Expression expression;

    public LogExpression(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public Complex evaluate() {
        return expression.evaluate().log();
    }

}
