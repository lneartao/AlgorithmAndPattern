package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class OrcWarlord extends Warlord {
    public OrcWarlord() {

    }

    @Override
    protected OrcWarlord clone() throws CloneNotSupportedException {
        return new OrcWarlord();
    }

    @Override
    public String toString() {
        return "Orcish Warlord";
    }
}
