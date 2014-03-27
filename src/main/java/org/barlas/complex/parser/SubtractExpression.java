package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class SubtractExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        return left.evaluate().sub(right.evaluate());
    }

}
