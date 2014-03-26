package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AssignmentStatement implements Statement {

    private final String name;
    private final Expression expression;

    private Complex[] symbolTable;
    private int index;

    public AssignmentStatement(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void preAnalyze(Context context) {
        index = context.getAndSetIndex(name);
        expression.preAnalyze(context);
    }

    @Override
    public void postAnalyze(Context context) {
        symbolTable = context.getSymbolTable();
        expression.postAnalyze(context);
    }

    @Override
    public void evaluate(Context context) {
        symbolTable[index] = expression.evaluate(context);
    }

}
