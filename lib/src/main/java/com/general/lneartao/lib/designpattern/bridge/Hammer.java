package com.general.lneartao.lib.designpattern.bridge;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/20.
 */

public class Hammer implements Weapon {
    private final Enchantment mEnchantment;

    public Hammer(Enchantment enchantment) {
        mEnchantment = enchantment;
    }

    @Override
    public void wield() {
        Logger.printl("The hammer is wielded");
        mEnchantment.onActivate();
    }

    @Override
    public void swing() {
        Logger.printl("The hammer is swinged");
        mEnchantment.apply();
    }

    @Override
    public void unwield() {
        Logger.printl("The hammer is unwielded");
        mEnchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return mEnchantment;
    }
}
