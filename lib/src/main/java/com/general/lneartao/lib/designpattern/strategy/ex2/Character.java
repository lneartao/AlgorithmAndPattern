package com.general.lneartao.lib.designpattern.strategy.ex2;

/**
 * @author lneartao
 * @date 2018/11/2.
 */
public abstract class Character {

    protected WeaponBehavior weaponBehavior;

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
