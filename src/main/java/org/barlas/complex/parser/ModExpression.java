package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ModExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public ModExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        return new Complex(left.evaluate().re() % right.evaluate().re());
    }

}
