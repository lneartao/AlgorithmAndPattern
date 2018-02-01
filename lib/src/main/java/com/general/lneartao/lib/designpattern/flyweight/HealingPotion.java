package com.general.lneartao.lib.designpattern.flyweight;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/22.
 */

public class HealingPotion implements Potion {
    @Override
    public void drink() {
        Logger.printl("You feel healed. Potion = " + System.identityHashCode(this));
    }
}
