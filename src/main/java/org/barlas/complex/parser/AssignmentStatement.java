package org.barlas.complex.parser;

public class AssignmentStatement implements Statement {

    private final String name;
    private final Expression expression;

    public AssignmentStatement(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    public void evaluate(Context context) {
        context.put(name, expression.evaluate(context));
    }

}
