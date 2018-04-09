package com.general.lneartao.lib.puzzlers.p47;

/**
 * @author lneartao
 * @date 2018/4/3.
 */
public class Dog {
    private static int woofCounter;

    public Dog() {
    }

    public static int woofCount() {
        return woofCounter;
    }

    public void woof() {
        woofCounter++;
    }
}
