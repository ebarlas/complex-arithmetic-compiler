package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public interface Expression extends Node {

    Complex evaluate();

}
