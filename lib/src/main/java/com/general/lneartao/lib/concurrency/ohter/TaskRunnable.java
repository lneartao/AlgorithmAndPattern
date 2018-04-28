package com.general.lneartao.lib.concurrency.ohter;

import java.util.concurrent.BlockingQueue;

import javafx.concurrent.Task;

/**
 * Restoring the interrupted status so as not to swallow the interrupt
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class TaskRunnable implements Runnable {
    BlockingQueue<Task> mQueue;

    @Override
    public void run() {
        try {
            processTask(mQueue.take());
        } catch (InterruptedException e) {
            // 恢复被中断的状态
            Thread.currentThread().interrupt();
        }
    }

    void processTask(Task task) {

    }


}
