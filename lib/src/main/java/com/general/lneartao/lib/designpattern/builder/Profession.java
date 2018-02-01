package com.general.lneartao.lib.designpattern.builder;

/**
 * Created by lneartao on 2017/11/14.
 */

public enum Profession {
    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
