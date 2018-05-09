package com.general.lneartao.lib.concurrency.test;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * Bounded buffer using condition queues
 *
 * @author lneartao
 * @date 2018/5/1.
 */
@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    // CONDITION PREDICATE: not-full (!isFull())
    // CONDITION PREDICATE: not-empty (!isEmpty())
    public BoundedBuffer() {
        this(100);
    }

    public BoundedBuffer(int size) {
        super(size);
    }

    /**
     * BLOCKS-UNTIL: not-full
     *
     * @param v
     * @throws InterruptedException
     */
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    /**
     * BLOCKS-UNTIL: not-empty
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }

    /**
     * 这里使用了条件通知
     * BLOCKS-UNTIL: not-full
     * Alternate form of put() using conditional notification
     *
     * @param v
     * @throws InterruptedException
     */
    public synchronized void alternatePut(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean wasEmpty = isEmpty();
        doPut(v);
        if (wasEmpty) {
            notifyAll();
        }
    }
}
