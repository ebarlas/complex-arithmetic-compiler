package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AndExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public AndExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        return left.evaluate().re() != 0.0 && right.evaluate().re() != 0.0 ? Constants.TRUE : Constants.FALSE;
    }

}
