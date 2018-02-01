package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public abstract class Warlord extends Prototype {
    @Override
    protected abstract Warlord clone() throws CloneNotSupportedException;
}
