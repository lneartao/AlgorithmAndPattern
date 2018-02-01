package com.general.lneartao.lib.designpattern.strategy;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/23.
 */

public class MeleeStrategy implements DragonSlayingStrategy {
    public MeleeStrategy() {
    }

    @Override
    public void execute() {
        Logger.printl("With your Excalibur you sever the dragon's head!");
    }
}
