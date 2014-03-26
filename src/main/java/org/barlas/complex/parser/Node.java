package org.barlas.complex.parser;

public interface Node {

    void preAnalyze(Context context);

    void postAnalyze(Context context);

}
