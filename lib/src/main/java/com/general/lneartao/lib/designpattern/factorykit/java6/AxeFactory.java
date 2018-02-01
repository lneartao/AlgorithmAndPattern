package com.general.lneartao.lib.designpattern.factorykit.java6;

import com.general.lneartao.lib.designpattern.factorykit.Axe;
import com.general.lneartao.lib.designpattern.factorykit.Weapon;

/**
 * Created by lneartao on 2017/11/13.
 */

public class AxeFactory implements WeaponFactory {
    @Override
    public Weapon create() {
        return new Axe();
    }
}
