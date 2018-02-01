package com.general.lneartao.lib.designpattern.interpreter;

/**
 * Created by lneartao on 2017/12/8.
 */

public class PlusExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpress;

    public PlusExpression(Expression leftExpression, Expression rightExpress) {
        this.leftExpression = leftExpression;
        this.rightExpress = rightExpress;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpress.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}
