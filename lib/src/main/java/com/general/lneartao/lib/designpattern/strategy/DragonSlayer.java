package com.general.lneartao.lib.designpattern.strategy;

/**
 * Created by lneartao on 2017/11/23.
 */

public class DragonSlayer {
    private DragonSlayingStrategy mDragonSlayingStrategy;

    public DragonSlayer(DragonSlayingStrategy dragonSlayingStrategy) {
        mDragonSlayingStrategy = dragonSlayingStrategy;
    }

    public void changeStrategy(DragonSlayingStrategy slayingStrategy) {
        mDragonSlayingStrategy = slayingStrategy;
    }

    public void goToBattle() {
        mDragonSlayingStrategy.execute();
    }
}
