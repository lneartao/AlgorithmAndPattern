package com.general.lneartao.lib.designpattern.factorykit.java8;

import com.general.lneartao.lib.designpattern.factorykit.Weapon;
import com.general.lneartao.lib.designpattern.factorykit.WeaponType;

import java.util.function.Supplier;

/**
 * Created by lneartao on 2017/11/13.
 */

public interface Builder {
    void add(WeaponType type, Supplier<Weapon> supplier);
}
