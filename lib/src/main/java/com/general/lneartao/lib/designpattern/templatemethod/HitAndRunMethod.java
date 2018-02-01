package com.general.lneartao.lib.designpattern.templatemethod;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/24.
 */

public class HitAndRunMethod extends StealingMethod {
    @Override
    protected String pickTarget() {
        return "old goblin woman";
    }

    @Override
    protected void confuseTarget(String target) {
        Logger.printl("Approach the " + target + " from behind.");
    }

    @Override
    protected void stealTheItem(String target) {
        Logger.printl("Grab the handbag and run away fast!");
    }
}
