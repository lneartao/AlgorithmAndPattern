package com.general.lneartao.lib.basic.reflect.array;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Array;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ArrayTroubleAgain {
    public static void main(String[] args) {
        try {
            Integer[] ary = new Integer[2];
            Array.setInt(ary, 0, 1);
            // solution
            Array.set(ary, 0, new Integer(1));
        } catch (IllegalArgumentException e) {
            Logger.printl("Unable to box!");
        }
    }
}
