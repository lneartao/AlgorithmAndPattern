package com.general.lneartao.lib.designpattern.strategy;

import com.general.lneartao.lib.Logger;

import java.util.ArrayList;

/**
 * Created by lneartao on 2017/11/23.
 */

public class App {
    public static void main(String[] args) {
        Logger.printl("Green dragon spotted ahead!");
        DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.goToBattle();
        Logger.printl("Red dragon emerges.");
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.goToBattle();
        Logger.printl("Black dragon lands before you.");
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.goToBattle();

        //Java 8
        Logger.printl("Green dragon spotted ahead!");
        dragonSlayer = new DragonSlayer(
                () -> Logger.printl("With your Excalibur you severe the dragon's head!"));
        dragonSlayer.goToBattle();
        Logger.printl("Red dragon emerges.");
        dragonSlayer.changeStrategy(
                () -> Logger.printl("You shoot the dragon with the magical crossbow and it falls dead on the ground!"));
        dragonSlayer.goToBattle();
        dragonSlayer.changeStrategy(
                () -> Logger.printl("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"));
        dragonSlayer.goToBattle();
        Logger.printl("Black dragon lands before you.");
        new ArrayList<>(-1);
    }
}
