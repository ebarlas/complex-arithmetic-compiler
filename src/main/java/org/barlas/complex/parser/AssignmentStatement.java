package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class AssignmentStatement extends AbstractNode implements Statement {

    private final String name;
    private final Expression expression;

    private Complex[] array;
    private int index;

    public AssignmentStatement(String name, Expression expression) {
        super(expression);
        this.name = name;
        this.expression = expression;
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
        array[index] = expression.evaluate();
    }

}
