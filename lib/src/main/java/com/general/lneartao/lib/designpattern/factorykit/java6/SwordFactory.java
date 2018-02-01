package com.general.lneartao.lib.designpattern.factorykit.java6;

import com.general.lneartao.lib.designpattern.factorykit.Sword;
import com.general.lneartao.lib.designpattern.factorykit.Weapon;

/**
 * Created by lneartao on 2017/11/13.
 */

public class SwordFactory implements WeaponFactory {
    @Override
    public Weapon create() {
        return new Sword();
    }
}
