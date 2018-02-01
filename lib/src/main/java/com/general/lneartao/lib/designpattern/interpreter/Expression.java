package com.general.lneartao.lib.designpattern.interpreter;

/**
 * Created by lneartao on 2017/12/8.
 */

public abstract class Expression {
    public abstract int interpret();

    @Override
    public abstract String toString();
}
