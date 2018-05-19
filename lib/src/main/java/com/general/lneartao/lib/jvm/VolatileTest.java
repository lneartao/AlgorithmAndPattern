package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

/**
 * volatile变量自增运算测试
 * 说明了volatile无法保证并发的安全性
 *
 * @author lneartao
 * @date 2018/5/19.
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }
        /*for (Thread thread : threads) {
            thread = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    increase();
                }
            });
            thread.start();
        }*/
        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        Logger.printl(race);
    }
}
