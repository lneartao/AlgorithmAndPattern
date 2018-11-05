package com.general.lneartao.lib.designpattern.strategy.ex2;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/11/2.
 */
public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        Logger.printl("Use Knife!");
    }
}
