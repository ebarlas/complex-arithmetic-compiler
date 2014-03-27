package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class PowerExpression extends AbstractNode implements Expression {

    private final Expression left;
    private final Expression right;

    public PowerExpression(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Complex evaluate() {
        Complex base = left.evaluate();
        Complex exp = right.evaluate();
        return base.im() == 0.0 && exp.im() == 0.0 ? new Complex(Math.pow(base.re(), exp.re())) : base.pow(exp);
    }

}
