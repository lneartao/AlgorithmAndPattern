package com.general.lneartao.lib.basic.reflect.constructor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorTroubleToo {
    public ConstructorTroubleToo() {
        throw new RuntimeException("exception in constructor");
    }

    public static void main(String[] args) {
//        cnew();
        ctornew();
    }

    private static void ctornew() {
        Class<?> clazz = ConstructorTroubleToo.class;
        try {
            clazz.getConstructor().newInstance();
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.printf("%n%nCaught exception: %s%n", e.getCause());
        }
    }

    private static void cnew() {
        Class<?> clazz = ConstructorTroubleToo.class;
        try {
            clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
