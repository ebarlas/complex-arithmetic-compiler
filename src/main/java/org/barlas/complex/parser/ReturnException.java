package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public class ReturnException extends RuntimeException {

    private final Complex[] values;

    public ReturnException(Complex[] values) {
        this.values = values;
    }

    public Complex[] getValues() {
        return values;
    }

}
