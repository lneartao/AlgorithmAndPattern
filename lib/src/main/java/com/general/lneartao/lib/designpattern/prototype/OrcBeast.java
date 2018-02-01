package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public class OrcBeast extends Beast {
    public OrcBeast() {

    }

    @Override
    public Beast clone() throws CloneNotSupportedException {
        return new OrcBeast();
    }

    @Override
    public String toString() {
        return "Orcish Beast";
    }
}
