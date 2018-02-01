package com.general.lneartao.lib.designpattern.strategy;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/23.
 */

public class ProjectileStrategy implements DragonSlayingStrategy {
    public ProjectileStrategy() {

    }

    @Override
    public void execute() {
        Logger.printl("You shoot the dragon with the magical crossbow and it falls dead on the ground");
    }
}
