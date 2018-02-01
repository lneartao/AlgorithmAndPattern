package com.general.lneartao.lib.designpattern.command;

/**
 * Created by lneartao on 2017/11/30.
 */

public class Goblin extends Target {
    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }
}
