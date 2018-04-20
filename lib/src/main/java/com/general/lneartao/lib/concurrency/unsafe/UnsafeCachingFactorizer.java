package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 要保持状态一致性，就需要在单个原子操作中更新所有相关的状态变量
 * 这里产生错误的原因在于：这两个变量无法同时更新，那么在这两次修改操作之间，其他线程将发现不变性条件被破坏了
 * （Atomic类在对单一域修改的同步中较好用～）
 * {@link com.general.lneartao.lib.concurrency.safe.SynchronizedFactorizer}
 * {@link com.general.lneartao.lib.concurrency.safe.CacheFactorizer}
 *
 * @author lneartao
 * @date 2018/4/12.
 */
@NotThreadSafe
public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void doSomeWork() {
        BigInteger i = getRequest();
        if (i.equals(lastNumber.get())) {
            postResponse(lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            // 这里产生错误
            lastNumber.set(i);
            lastFactors.set(factors);
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
