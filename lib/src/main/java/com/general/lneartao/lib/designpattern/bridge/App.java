package com.general.lneartao.lib.designpattern.bridge;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/20.
 */

public class App {
    public static void main(String[] args) {
        Logger.printl("The knight receives an enchanted sword.");
        Sword enchantedSword = new Sword(new SoulEatingEnchantment());
        enchantedSword.wield();
        enchantedSword.swing();
        enchantedSword.unwield();

        Logger.printl("The valkrie receives an  enchanted hammer.");
        Hammer hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
    }
}
