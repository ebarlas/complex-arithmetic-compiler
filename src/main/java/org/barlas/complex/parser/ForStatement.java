package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ForStatement implements Statement {

    private final String name;
    private final int from;
    private final int to;
    private final Statement statement;

    public ForStatement(String name, int from, int to, Statement statement) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.statement = statement;
    }

    public void evaluate(Context context) {
        for(int i=from; i<=to; i++) {
            context.put(name, new Complex(i));
            statement.evaluate(context);
        }
    }
}
