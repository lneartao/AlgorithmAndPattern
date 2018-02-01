package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public abstract class Prototype implements Cloneable {
    @Override
    protected abstract Object clone() throws CloneNotSupportedException;
}
