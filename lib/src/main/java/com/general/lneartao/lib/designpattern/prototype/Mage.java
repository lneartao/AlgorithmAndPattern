package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public abstract class Mage extends Prototype {
    @Override
    protected abstract Mage clone() throws CloneNotSupportedException;
}
