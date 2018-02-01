package com.general.lneartao.lib.designpattern.templatemethod;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/24.
 */

public abstract class StealingMethod {
    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String target);

    public void steal() {
        String target = pickTarget();
        Logger.printl("The target has been chosen as " + target);
        confuseTarget(target);
        stealTheItem(target);
    }
}
