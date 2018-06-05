package com.general.lneartao.lib.basic.reflect.enumerated;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举类型不允许实例化（所以枚举保证了单例的线程安全性~）
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class EnumTrouble {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Charge.class;
            Constructor[] ctors = clazz.getDeclaredConstructors();
            for (Constructor ctor : ctors) {
                System.out.printf("Constructor: %s%n", ctor.toGenericString());
                ctor.setAccessible(true);
                ctor.newInstance();
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

enum Charge {
    POSITIVE, NEGATIVE, NEUTRAL;

    Charge() {
        Logger.printl("under construction!");
    }
}
