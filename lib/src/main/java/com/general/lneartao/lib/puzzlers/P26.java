package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 边界的问题还是要注意
 *
 * @author lneartao
 * @date 2018/3/29.
 */

public class P26 {
    private static final int END = Integer.MAX_VALUE;
    private static final int START = END - 100;

    public static void main(String[] args) {
        wrongOne();
        correctOne();
        betterOne();
    }

    private static void betterOne() {
        int count = 0;
        int i = Integer.MIN_VALUE;
        do {
            count++;
        } while (i++ != Integer.MAX_VALUE);
        Logger.printl(count);
    }

    /**
     * 这种方法可以解决上溢或下溢的问题，但是效率不好
     */
    private static void correctOne() {
        int count = 0;
        for (long i = START; i <= END; i++) {
            count++;
        }
        Logger.printl(count);
    }

    private static void wrongOne() {
        int count = 0;
        for (int i = START; i <= END; i++) {
            count++;
        }
        Logger.printl(count);
    }
}
