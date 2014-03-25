package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class LogExpression implements Expression {

    private final Expression expression;

    public LogExpression(Expression expression) {
        this.expression = expression;
    }

    public Complex evaluate(Context context) {
        return expression.evaluate(context).log();
    }

}
