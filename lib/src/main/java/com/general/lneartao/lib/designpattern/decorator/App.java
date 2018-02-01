package com.general.lneartao.lib.designpattern.decorator;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/15.
 */

public class App {
    public static void main(String[] args) {
        Logger.printl("a simple looking troll approaches");
        Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        Logger.printl("Simple troll power {" + troll.getAttackPower() + "}.");

        Logger.printl("A troll with huge club surprises you.");
        troll = new ClubbedTroll(troll);
        troll.attack();
        troll.fleeBattle();
        Logger.printl("Clubbed troll power{" + troll.getAttackPower() + "}.");
    }
}
