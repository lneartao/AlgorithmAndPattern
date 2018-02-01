package com.general.lneartao.lib.designpattern.factorykit.java6;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.designpattern.factorykit.Weapon;

/**
 * Created by lneartao on 2017/11/13.
 */

public class App {

    public static void main(String[] args) {
        WeaponFactory weaponFactory = new SwordFactory();
        Weapon weapon = weaponFactory.create();
        Logger.printl(weapon.toString());

        WeaponFactory weaponFactory2 = new AxeFactory();
        Weapon weapon2 = weaponFactory2.create();
        Logger.printl(weapon2.toString());
    }
}
