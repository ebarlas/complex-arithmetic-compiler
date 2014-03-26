package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ForStatement implements Statement {

    private final String name;
    private final int from;
    private final int to;
    private final Statement statement;

    private Complex[] symbolTable;
    private int index;

    public ForStatement(String name, int from, int to, Statement statement) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.statement = statement;
    }

    @Override
    public void preAnalyze(Context context) {
        index = context.getAndSetIndex(name);
        statement.preAnalyze(context);
    }

    @Override
    public void postAnalyze(Context context) {
        symbolTable = context.getSymbolTable();
        statement.postAnalyze(context);
    }

    @Override
    public void evaluate(Context context) {
        for(int i=from; i<=to; i++) {
            symbolTable[index] = new Complex(i);
            statement.evaluate(context);
        }
    }
}
