package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 无论是Timer类还是Thread.sleep方法，都不能保证具有实时性
 * 1、Thread.join方法表示正在被连接的那个Thread实例上调用Object.wait(),这样就在等待期间释放了对象的锁，
 * 那么别的Thread就能调用keepWorking()设置quittingTime为false，这就是造成错误写法无限挂起的原因
 * 2、实例锁、类锁、私有域锁、ReentrantLock等锁
 * 要去看Java并发编程实战
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P77 extends Thread {

    private volatile boolean quittingTime = false;

    @Override
    public void run() {
        while (!quittingTime) {
            pretendToWork();
        }
        Logger.printl("Beer is good");
    }

    private void pretendToWork() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }
    }

    // 有问题的写法
    /*synchronized void quit() throws InterruptedException {
        quittingTime = true;
        join();
    }

    synchronized void keepWorking() {
        quittingTime = false;
    }*/

    // 正确的写法
    private final Object lock = new Object();

    void quit() throws InterruptedException {
        synchronized (lock) {
            quittingTime = true;
            join();
        }
    }

    void keepWorking() {
        synchronized (lock) {
            quittingTime = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final P77 worker = new P77();
        worker.start();
        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        }, 500);
        Thread.sleep(400);
        worker.quit();
    }
}
