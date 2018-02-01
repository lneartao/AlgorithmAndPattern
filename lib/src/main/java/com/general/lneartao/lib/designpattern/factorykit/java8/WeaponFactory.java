package com.general.lneartao.lib.designpattern.factorykit.java8;

import com.general.lneartao.lib.designpattern.factorykit.Weapon;
import com.general.lneartao.lib.designpattern.factorykit.WeaponType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by lneartao on 2017/11/13.
 */

public interface WeaponFactory {
    Weapon create(WeaponType type);

    static WeaponFactory factory(Consumer<Builder> consumer){
        final Map<WeaponType, Supplier<Weapon>> map  =new HashMap<>();
        consumer.accept(map::put);
        return type -> map.get(type).get();
    }
}
