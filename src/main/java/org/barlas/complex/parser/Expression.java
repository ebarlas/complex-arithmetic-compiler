package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;

public interface Expression {

    Complex evaluate(Context context);

}
