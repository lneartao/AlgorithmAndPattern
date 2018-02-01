package com.general.lneartao.lib.designpattern.proxy;

/**
 * Created by lneartao on 2017/11/16.
 */

public class Wizard {
    private final String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
