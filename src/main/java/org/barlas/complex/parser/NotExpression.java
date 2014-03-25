package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NotExpression implements Expression {

    private final Expression expression;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    public Complex evaluate(Context context) {
        return expression.evaluate(context).re() == 0.0 ? Constants.TRUE : Constants.FALSE;
    }

}
