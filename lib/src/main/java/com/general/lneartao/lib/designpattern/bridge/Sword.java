package com.general.lneartao.lib.designpattern.bridge;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/20.
 */

public class Sword implements Weapon {
    private final Enchantment mEnchantment;

    public Sword(Enchantment enchantment) {
        mEnchantment = enchantment;
    }

    @Override
    public void wield() {
        Logger.printl("The sword is wielded");
        mEnchantment.onActivate();
    }

    @Override
    public void swing() {
        Logger.printl("The sword is swinged");
        mEnchantment.apply();
    }

    @Override
    public void unwield() {
        Logger.printl("The sword is unwielded");
        mEnchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return mEnchantment;
    }
}
