package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class ElfMage extends Mage {
    public ElfMage() {

    }

    @Override
    protected ElfMage clone() throws CloneNotSupportedException {
        return new ElfMage();
    }

    @Override
    public String toString() {
        return "Elven Mage";
    }
}
