package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 大数做算术运算时要注意溢出问题
 *
 * @author lneartao
 * @date 2018/3/26.
 */

public class P3 {
    public static void main(String[] args) {
        divideWrong();
        divideCollect();
    }

    /**
     * 该方法实际是以int运算来执行的，所以就造成了溢出问题
     */
    private static void divideWrong() {
        long microsPerDay = 24 * 60 * 60 * 1000 * 1000;
        long millisPerDay = 24 * 60 * 60 * 1000;
        Logger.printl(microsPerDay / millisPerDay);
    }

    private static void divideCollect() {
        long microsPerDay = 24L * 60 * 60 * 1000 * 1000;
        long millisPerDay = 24L * 60 * 60 * 1000;
        Logger.printl(microsPerDay / millisPerDay);
    }
}
