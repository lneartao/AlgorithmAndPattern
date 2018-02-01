package com.general.lneartao.lib.designpattern.interpreter;

/**
 * Created by lneartao on 2017/12/8.
 */

public class NumberExpression extends Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String s) {
        number = Integer.parseInt(s);
    }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String toString() {
        return "number";
    }
}
