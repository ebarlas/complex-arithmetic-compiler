package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

import java.util.List;

public class ReturnStatement extends AbstractNode implements Statement {

    private final Expression[] expressions;

    public ReturnStatement(List<Expression> expressions) {
        super(expressions.toArray(new Expression[expressions.size()]));
        this.expressions = (Expression[])getChildren();
    }

    @Override
    public void evaluate() {
        Complex[] values = new Complex[expressions.length];
        for(int i=0; i<values.length; i++) {
            values[i] = expressions[i].evaluate();
        }

        throw new ReturnException(values);
    }

}
