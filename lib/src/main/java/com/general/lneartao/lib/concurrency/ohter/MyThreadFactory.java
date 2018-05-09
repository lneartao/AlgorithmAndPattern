package com.general.lneartao.lib.concurrency.ohter;

import java.util.concurrent.ThreadFactory;

/**
 * @author lneartao
 * @date 2018/4/30.
 */
public class MyThreadFactory implements ThreadFactory {
    private final String threadName;

    public MyThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, threadName);
    }
}
