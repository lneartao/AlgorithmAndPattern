package com.general.lneartao.lib.designpattern.bridge;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/20.
 */

public class SoulEatingEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        Logger.printl("The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        Logger.printl("The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        Logger.printl("Bloodlust slowly disappears.");
    }
}
