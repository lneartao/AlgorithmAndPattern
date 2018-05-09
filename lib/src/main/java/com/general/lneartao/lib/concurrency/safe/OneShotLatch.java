package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 使用AbstractQueuedSynchronizer实现的二元闭锁
 *
 * @author lneartao
 * @date 2018/5/2.
 */
@ThreadSafe
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            // 如果闭锁时开的(state==1)，那么这个操作将成功，否则失败
            return getState() == 1 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1); // 现在打开闭锁
            return true; // 现在其他线程可以获取该闭锁
        }
    }
}
