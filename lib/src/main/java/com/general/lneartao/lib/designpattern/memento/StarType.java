package com.general.lneartao.lib.designpattern.memento;

/**
 * Created by lneartao on 2017/12/1.
 */

public enum StarType {
    SUN("sun"), RED_GIANT("red giant"), WHITE_DWARF("white dwarf"), SUPERNOVA("supernova"), DEAD("dead"), UNDEFINED("undefined");
    private String title;

    StarType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
