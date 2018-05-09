package com.general.lneartao.lib.concurrency;

/**
 * @author lneartao
 * @date 2018/5/1.
 */
public class Util {

    /**
     * 非线程安全的简单随机算法
     *
     * @param y
     * @return
     */
    public static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
}
