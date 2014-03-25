package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

import java.util.List;

public class ReturnStatement implements Statement {

    private final Expression[] expressions;

    public ReturnStatement(List<Expression> expressions) {
        this.expressions = expressions.toArray(new Expression[expressions.size()]);
    }

    public void evaluate(Context context) {
        Complex[] values = new Complex[expressions.length];
        for(int i=0; i<values.length; i++) {
            values[i] = expressions[i].evaluate(context);
        }

        throw new ReturnException(values);
    }

}
