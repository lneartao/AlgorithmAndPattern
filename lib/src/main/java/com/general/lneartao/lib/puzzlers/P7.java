package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 操作符的操作数是从左向右求值的
 * 在Java中最好不要用异或的方法交换两个值，而是使用中间值的方法
 * @author lneartao
 * @date 2018/3/26.
 */

public class P7 {
    public static void main(String[] args) {
        int x = 1984;
        int y = 2001;
        x ^= y ^= x ^= y;
        Logger.printl("x= " + x + "; y= " + y);
    }

    private static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }
}
