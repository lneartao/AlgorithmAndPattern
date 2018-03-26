package com.general.lneartao.lib.puzzlers;

/**
 * @author lneartao
 * @date 2018/3/26.
 */

public class p1 {

    /**
     * 该方法很容易想到，但是负数的情况都会判断错误，这是Java对取余操作符的定义所产生的后果
     * (a/b)*b+(a%b) == a
     *
     * @param i
     * @return
     */
    public static boolean isOddWrong(int i) {
        return i % 2 == 1;
    }

    /**
     * 这个方法是正确的
     *
     * @param i
     * @return
     */
    public static boolean isOddOk(int i) {
        return i % 2 != 0;
    }

    /**
     * 这个方法是性能最优的
     *
     * @param i
     * @return
     */
    public static boolean isOdd(int i) {
        return (i & 1) != 0;
    }
}
