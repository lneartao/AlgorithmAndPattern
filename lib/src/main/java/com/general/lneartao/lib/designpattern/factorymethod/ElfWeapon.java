package com.general.lneartao.lib.designpattern.factorymethod;

/**
 * Created by lneartao on 2017/11/13.
 */

public class ElfWeapon implements Weapon {
    private WeaponType mWeaponType;

    public ElfWeapon(WeaponType weaponType) {
        mWeaponType = weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return mWeaponType;
    }

    @Override
    public String toString() {
        return "Elven" + mWeaponType;
    }
}
