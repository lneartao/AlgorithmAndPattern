package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;
import com.general.lneartao.lib.concurrency.immutable.OneValueCache;

import java.math.BigInteger;

/**
 * 使用volatile类型来发布不可变对象来保证线程安全
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class VolatileCachedFactorizer {
    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void doSomeWork() {
        BigInteger integer = getRequest();
        BigInteger[] factors = factor(integer);
        if (factors == null) {
            factors = factor(integer);
            cache = new OneValueCache(integer, factors);
        }
        postResponse(factors);
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
