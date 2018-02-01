package com.general.lneartao.lib.designpattern.bridge;

/**
 * Created by lneartao on 2017/11/20.
 */

public interface Weapon {
    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
