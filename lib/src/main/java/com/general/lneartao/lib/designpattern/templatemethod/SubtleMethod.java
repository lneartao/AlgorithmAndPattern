package com.general.lneartao.lib.designpattern.templatemethod;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/24.
 */

public class SubtleMethod extends StealingMethod {
    @Override
    protected String pickTarget() {
        return "shop keeper";
    }

    @Override
    protected void confuseTarget(String target) {
        Logger.printl("Approach the " + target + " with teas running and hug him!");
    }

    @Override
    protected void stealTheItem(String target) {
        Logger.printl("While in close contact grab the " + target + "'s wallet.");
    }
}
