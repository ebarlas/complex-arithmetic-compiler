package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ForStatement extends AbstractNode implements Statement {

    private final String name;
    private final int from;
    private final int to;
    private final Statement statement;

    private Complex[] array;
    private int index;

    public ForStatement(String name, int from, int to, Statement statement) {
        super(statement);
        this.name = name;
        this.from = from;
        this.to = to;
        this.statement = statement;
    }

    @Override
    public void compile(SymbolTable symbolTable) {
        index = symbolTable.getIndex(name);
        super.compile(symbolTable);
    }

    @Override
    public void compile(Variables variables) {
        array = variables.getArray();
        super.compile(variables);
    }

    @Override
    public void evaluate() {
        for(int i=from; i<=to; i++) {
            array[index] = new Complex(i);
            statement.evaluate();
        }
    }
}
