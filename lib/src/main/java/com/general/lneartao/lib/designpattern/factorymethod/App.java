package com.general.lneartao.lib.designpattern.factorymethod;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/13.
 */

public class App {
    private final BlackSmith mBlacksmith;

    public App(BlackSmith blacksmith) {
        mBlacksmith = blacksmith;
    }

    public static void main(String[] args) {
        App app = new App(new OrcBlackSmith());
        app.manufactureWeapons();

        app = new App(new ElfBlackSmith());
        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon;
        weapon = mBlacksmith.manufactureWeapon(WeaponType.SPEAR);
        Logger.printl(weapon.toString());
        weapon = mBlacksmith.manufactureWeapon(WeaponType.AXE);
        Logger.printl(weapon.toString());
    }
}
