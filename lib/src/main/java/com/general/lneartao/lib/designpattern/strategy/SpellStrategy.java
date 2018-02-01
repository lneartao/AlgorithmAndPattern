package com.general.lneartao.lib.designpattern.strategy;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/23.
 */

public class SpellStrategy implements DragonSlayingStrategy {
    public SpellStrategy() {
    }

    @Override
    public void execute() {
        Logger.printl("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
    }
}
