package com.general.lneartao.lib.designpattern.command;

/**
 * Created by lneartao on 2017/11/30.
 */

public enum Visibility {
    VISIBLE("visible"), INVISIBLE("invisible");
    private String title;

    Visibility(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
