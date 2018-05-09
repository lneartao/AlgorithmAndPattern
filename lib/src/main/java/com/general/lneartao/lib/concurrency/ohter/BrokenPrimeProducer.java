package com.general.lneartao.lib.concurrency.ohter;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 不可靠的取消操作将把生产者置于阻塞的操作中
 * 因生产者的速度超过了消费者，并在put方法中阻塞时，它无法从阻塞的put方法中恢复过来
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/30.
 * @see PrimeProducer
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {

        }
    }

    public void cancel() {
        cancelled = true;
    }

}
