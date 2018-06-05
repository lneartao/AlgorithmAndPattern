package com.general.lneartao.lib.basic.reflect.array;

import java.lang.reflect.Array;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ArrayTroubleToo {
    public static void main(String[] args) {
        Object o = new int[2];
        // widening. succeeds
        Array.setShort(o, 0, (short) 2);
        // narrowing. fails
        Array.setLong(o, 1, 2L);
    }
}
