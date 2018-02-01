package com.general.lneartao.lib.designpattern.prototype;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/14.
 */

public class App {
    public static void main(String[] args) {
        HeroFactory heroFactory;
        Mage mage;
        Warlord warlord;
        Beast beast;

        heroFactory = new HeroFactoryImpl(new ElfMage(), new ElfWarlord(), new ElfBeast());
        mage = heroFactory.createMage();
        warlord = heroFactory.createWarlord();
        beast = heroFactory.createBeast();
        Logger.printl(mage.toString());
        Logger.printl(warlord.toString());
        Logger.printl(beast.toString());

        heroFactory = new HeroFactoryImpl(new OrcMage(), new OrcWarlord(), new OrcBeast());
        mage = heroFactory.createMage();
        warlord = heroFactory.createWarlord();
        beast = heroFactory.createBeast();
        Logger.printl(mage.toString());
        Logger.printl(warlord.toString());
        Logger.printl(beast.toString());
    }
}
