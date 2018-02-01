package com.general.lneartao.lib.designpattern.command;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/30.
 */

public abstract class Target {
    private Size size;
    private Visibility visibility;

    public Target() {
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public abstract String toString();

    public void printStatus() {
        Logger.printl("size= " + getSize() + " visibility= " + getVisibility());
    }
}
