package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class VariableExpression extends AbstractNode implements Expression {

    private final String name;

    private Complex[] array;
    private int index;

    public VariableExpression(String name) {
        this.name = name;
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
    public Complex evaluate() {
        return array[index];
    }
}
