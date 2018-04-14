package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.math.BigInteger;

/**
 * 本书中建议不要这么写，原因是性能问题
 * 但是据说现在的JVM都已经优化过synchronized，所以现在这似乎是一种可行的写法
 *
 * @author lneartao
 * @date 2018/4/12.
 */
@ThreadSafe
public class SynchronizedFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    public synchronized void doSomeWork() {
        BigInteger i = getRequest();
        if (i.equals(lastNumber)) {
            postResponse(lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            postResponse(factors);
        }
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

    private BigInteger getRequest() {
        return new BigInteger("7");
    }

    private void postResponse(BigInteger[] bigIntegers) {

    }
}
