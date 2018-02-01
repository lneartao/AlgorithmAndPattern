package com.general.lneartao.lib.designpattern.decorator;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/15.
 */

public class SimpleTroll implements Troll {
    @Override
    public void attack() {
        Logger.printl("The troll tries to grab you!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        Logger.printl("The troll shrieks in horror and runs away");
    }
}
