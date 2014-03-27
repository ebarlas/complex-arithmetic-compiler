package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class Variables {

    private final Complex[] array;

    public Variables(Complex[] array) {
        this.array = array;
    }

    public Complex[] getArray() {
        return array;
    }

    public void init() {
        for(int i=0; i<array.length; i++) {
            array[i] = Constants.ZERO;
        }
    }

}
