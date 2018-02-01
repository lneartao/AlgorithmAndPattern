package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class ElfBeast extends Beast {
    public ElfBeast() {
    }

    @Override
    public Beast clone() throws CloneNotSupportedException {
        return new ElfBeast();
    }

    @Override
    public String toString() {
        return "Elven eagle";
    }
}
