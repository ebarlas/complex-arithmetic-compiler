package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class NotEqualsExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public NotEqualsExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        Complex a = left.evaluate();
        Complex b = right.evaluate();
        return a.re() != b.re() || a.im() != b.im() ? Constants.TRUE : Constants.FALSE;
    }

}
