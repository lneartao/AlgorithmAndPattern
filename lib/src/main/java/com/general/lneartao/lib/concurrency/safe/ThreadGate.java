package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * 使用wait和notifyAll来实现可重新关闭的阀门
 *
 * @author lneartao
 * @date 2018/5/2.
 */
@ThreadSafe
public class ThreadGate {
    /**
     * 条件谓语：opened-since(n) (isOpen || generation > n)
     */
    @GuardedBy("this")
    private boolean isOpen;
    @GuardedBy("this")
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    /**
     * 阻塞直到：opened-since(generation on entry)
     *
     * @throws InterruptedException
     */
    public synchronized void awati() throws InterruptedException {
        int arrivalGeneration = generation;
        while (!isOpen && arrivalGeneration == generation) {
            wait();
        }
    }
}
