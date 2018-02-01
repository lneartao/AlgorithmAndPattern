package com.general.lneartao.lib.designpattern.factorymethod;

/**
 * Created by lneartao on 2017/11/13.
 */

public enum WeaponType {
    AXE("axe"), SWORD("sword"), SPEAR("spear"), UNDEFINED("");
    private String title;

    WeaponType(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
