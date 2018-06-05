package com.general.lneartao.lib.basic.reflect.array;

import java.lang.reflect.Array;

/**
 * 空数组
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ArrayTrouble {
    public static void main(String[] args) {
        Object o = Array.newInstance(int.class, 0);
        int[] i = (int[]) o;
        int[] j = new int[0];
        System.out.printf("i.length = %d, j.length = %d, args.length = %d%n", i.length, j.length, args.length);
        Array.getInt(o, 0);
    }
}
