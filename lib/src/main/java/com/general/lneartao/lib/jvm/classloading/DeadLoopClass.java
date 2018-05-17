package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * 字段解析
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class DeadLoopClass {
    static {
        // 如果不加上这个If语句，编译器将提示“Initializer does not complete normally” 并拒绝编译
        if (true) {
            Logger.printl(Thread.currentThread() + "init DealLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            Logger.printl(Thread.currentThread() + "start");
            DeadLoopClass dlc = new DeadLoopClass();
            Logger.printl(Thread.currentThread() + "run over");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
