package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class ElfWarlord extends Warlord {
    public ElfWarlord() {

    }

    @Override
    protected ElfWarlord clone() throws CloneNotSupportedException {
        return new ElfWarlord();
    }

    @Override
    public String toString() {
        return "Elven Warlord";
    }
}
