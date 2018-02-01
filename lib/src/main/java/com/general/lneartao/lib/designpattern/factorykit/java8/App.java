package com.general.lneartao.lib.designpattern.factorykit.java8;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.designpattern.factorykit.Axe;
import com.general.lneartao.lib.designpattern.factorykit.Sword;
import com.general.lneartao.lib.designpattern.factorykit.Weapon;
import com.general.lneartao.lib.designpattern.factorykit.WeaponType;

/**
 * Created by lneartao on 2017/11/13.
 */

public class App {
    public static void main(String[] args) {
        WeaponFactory factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.SWORD, Sword::new);
        });
        Weapon axe = factory.create(WeaponType.AXE);
        Logger.printl(axe.toString());
    }
}
