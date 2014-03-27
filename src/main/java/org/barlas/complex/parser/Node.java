package org.barlas.complex.parser;

public interface Node {

    Node[] getChildren();

    void compile(SymbolTable symbolTable);

    void compile(Variables variables);

}
