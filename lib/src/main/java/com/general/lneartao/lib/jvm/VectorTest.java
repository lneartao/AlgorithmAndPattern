package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.util.Vector;

/**
 * 对Vector线程安全的测试
 * 需要用synchronized同步，否则会报异常
 *
 * @author lneartao
 * @date 2018/5/19.
 */
public class VectorTest {
    private static Vector<Integer> sVector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 20; i++) {
                sVector.add(i);
            }

            Thread removeThread = new Thread(() -> {
                synchronized (sVector) {
                    for (int i = 0; i < sVector.size(); i++) {
                        sVector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(() -> {
                synchronized (sVector) {
                    for (int i = 0; i < sVector.size(); i++) {
                        Logger.printl(sVector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) ;
        }
    }
}
