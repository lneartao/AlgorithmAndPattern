package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;

import java.math.BigInteger;

/**
 * 尽可能的减少同步代码块，提高性能
 *
 * @author lneartao
 * @date 2018/4/16.
 */
public class CacheFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void doSomeWork() {
        BigInteger i = getRequest();
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        postResponse(factors);
    }

    private BigInteger getRequest() {
        return new BigInteger("4");
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

    private void postResponse(BigInteger[] bigIntegers) {

    }

}
