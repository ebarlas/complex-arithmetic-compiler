package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class VariableExpression implements Expression {

    private final String name;

    private Complex[] symbolTable;
    private int index;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public void preAnalyze(Context context) {
        index = context.getAndSetIndex(name);
    }

    @Override
    public void postAnalyze(Context context) {
        symbolTable = context.getSymbolTable();
    }

    @Override
    public Complex evaluate(Context context) {
        return symbolTable[index];
    }
}
