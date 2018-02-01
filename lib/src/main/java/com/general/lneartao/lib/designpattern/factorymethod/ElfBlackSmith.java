package com.general.lneartao.lib.designpattern.factorymethod;

/**
 * Created by lneartao on 2017/11/13.
 */

public class ElfBlackSmith implements BlackSmith {
    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new ElfWeapon(weaponType);
    }
}
