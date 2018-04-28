package com.general.lneartao.lib.concurrency.ohter.memozier;

import java.math.BigInteger;

/**
 * @author lneartao
 * @date 2018/4/27.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // after deep thought...
        return new BigInteger(arg);
    }
}
