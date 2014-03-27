package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public int getIndex(String name) {
        Integer index = map.get(name);
        if(index == null) {
            index = map.size();
            map.put(name, index);
        }

        return index;
    }

    public Variables compile() {
        return new Variables(new Complex[map.size()]);
    }

}
