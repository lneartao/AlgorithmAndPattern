package com.general.lneartao.lib.designpattern.command;

/**
 * Created by lneartao on 2017/11/30.
 */

public abstract class Command {
    public abstract void execute(Target target);

    public abstract void undo();

    public abstract void redo();

    @Override
    public abstract String toString();
}
