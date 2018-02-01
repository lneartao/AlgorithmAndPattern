package com.general.lneartao.lib.designpattern.decorator;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/15.
 */

public class ClubbedTroll implements Troll {
    private Troll decorated;

    public ClubbedTroll(Troll decorated) {
        this.decorated = decorated;
    }

    @Override
    public void attack() {
        decorated.attack();
        Logger.printl("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
