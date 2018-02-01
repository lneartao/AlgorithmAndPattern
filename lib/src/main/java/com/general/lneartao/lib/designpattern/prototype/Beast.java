package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public abstract class Beast extends Prototype {
    @Override
    public abstract Beast clone() throws CloneNotSupportedException;
}
