package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Integer> indexes = new HashMap<String, Integer>();
    private Complex[] symbolTable;

    private boolean committed = false;

    public Integer getIndex(String name) {
        return indexes.get(name);
    }

    public int getAndSetIndex(String name) {
        assertNotCommitted();

        Integer index = indexes.get(name);
        if(index == null) {
            index = indexes.size();
            indexes.put(name, index);
        }

        return index;
    }

    public void commit() {
        assertNotCommitted();
        symbolTable = new Complex[indexes.size()];
        committed = true;
    }

    public void init() {
        assertCommitted();
        for(int i=0; i<symbolTable.length; i++) {
            symbolTable[i] = Constants.ZERO;
        }
    }

    public Complex[] getSymbolTable() {
        assertCommitted();
        return symbolTable;
    }

    private void assertCommitted() {
        if(!committed) {
            throw new IllegalStateException();
        }
    }

    private void assertNotCommitted() {
        if(committed) {
            throw new IllegalStateException();
        }
    }

}
