package com.general.lneartao.lib.puzzlers.p47;

/**
 * @author lneartao
 * @date 2018/4/3.
 */
public class Cat {
    private static int meowCounter;

    public Cat() {
    }

    public static int meowCount() {
        return meowCounter;
    }

    public void meow() {
        meowCounter++;
    }
}
