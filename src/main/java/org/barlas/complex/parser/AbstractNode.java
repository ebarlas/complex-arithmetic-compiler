package org.barlas.complex.parser;

public class AbstractNode implements Node {

    private final Node[] children;

    public AbstractNode(Node ... children) {
        this.children = children;
    }

    @Override
    public Node[] getChildren() {
        return children;
    }

    @Override
    public void compile(SymbolTable symbolTable) {
        for(Node child : children) {
            child.compile(symbolTable);
        }
    }

    @Override
    public void compile(Variables variables) {
        for(Node child : children) {
            child.compile(variables);
        }
    }
}
