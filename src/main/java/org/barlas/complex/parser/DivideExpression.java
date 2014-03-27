package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class DivideExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public DivideExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        return left.evaluate().div(right.evaluate());
    }

}
