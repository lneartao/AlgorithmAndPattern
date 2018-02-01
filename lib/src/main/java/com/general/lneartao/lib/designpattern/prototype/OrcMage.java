package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class OrcMage extends Mage {
    public OrcMage() {

    }

    @Override
    protected OrcMage clone() throws CloneNotSupportedException {
        return new OrcMage();
    }

    @Override
    public String toString() {
        return "Orcish Mage";
    }
}
