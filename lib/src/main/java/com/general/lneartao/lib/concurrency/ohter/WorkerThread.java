package com.general.lneartao.lib.concurrency.ohter;

import java.util.concurrent.BlockingQueue;

/**
 * Serialized access to a task queue
 * 对任务队列的串行访问
 *
 * @author lneartao
 * @date 2018/5/1.
 */
public class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                // allow thread to exit
            }
        }
    }
}
