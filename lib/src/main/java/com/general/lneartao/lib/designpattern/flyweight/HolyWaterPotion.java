package com.general.lneartao.lib.designpattern.flyweight;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/22.
 */

public class HolyWaterPotion implements Potion {
    @Override
    public void drink() {
        Logger.printl("You feel blessed. Potion = " + System.identityHashCode(this));
    }
}
