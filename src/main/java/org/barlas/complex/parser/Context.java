package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Complex> map = new HashMap<String, Complex>();

    public void put(String s, Complex obj) {
        map.put(s, obj);
    }

    public Complex get(String s) {
        return map.get(s);
    }

}
