package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.Logger;

/**
 * 这个例子在多线程环境中有可能会出现3种情况
 * 1、输出42
 * 2、输出0
 * 3、无法结束
 * 可是在我编译运行的时候只会打印出42，在我这台电脑似乎没有进行代码重排序
 *
 * @author lneartao
 * @date 2018/4/17.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            Logger.printl(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
