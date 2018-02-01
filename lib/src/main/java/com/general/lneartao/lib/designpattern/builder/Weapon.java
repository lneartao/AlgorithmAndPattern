package com.general.lneartao.lib.designpattern.builder;

/**
 * Created by lneartao on 2017/11/14.
 */

public enum Weapon {
    DAGGER, SWORD, AXE, WARHAMMER, BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
