package com.general.lneartao.lib.puzzlers.p47;

/**
 * @author lneartao
 * @date 2018/4/3.
 */
public class Counter {
    private static int count = 0;

    public static  synchronized void increment() {
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }
}
