package com.general.lneartao.lib.concurrency.ohter;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @author lneartao
 * @date 2018/4/30.
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            // allow thread to exit
        }
    }

    public void cancel() {
        interrupt();
    }
}
