package com.general.lneartao.lib.basic.reflect.constructor;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorTroubleAccess {
    public static void main(String[] args) {
        try {
            Constructor constructor = Deny.class.getDeclaredConstructor();
//            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Deny {
    private Deny() {
        Logger.printl("Deny constructor!");
    }
}
