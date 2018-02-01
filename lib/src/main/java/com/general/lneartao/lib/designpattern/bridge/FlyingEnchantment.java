package com.general.lneartao.lib.designpattern.bridge;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/20.
 */

public class FlyingEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        Logger.printl("The item begins to glow faintly.");
    }

    @Override
    public void apply() {
        Logger.printl("The item flies and strikes the enemies finally returning to owner's hand.");
    }

    @Override
    public void onDeactivate() {
        Logger.printl("The item's glow fades.");
    }
}
