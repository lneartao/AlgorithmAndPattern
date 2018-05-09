package com.general.lneartao.lib.concurrency.ohter;

import com.general.lneartao.lib.Logger;

/**
 * 不要这么做，因为有可能重排序后出现几种不同的情况
 *
 * @author lneartao
 * @date 2018/5/8.
 */
public class PossibleReording {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread other = new Thread(() -> {
            b = 1;
            y = a;
        });
        one.start();
        other.start();
        one.join();
        other.join();
        Logger.printl("x: " + x + "; y: " + y);
    }
}
