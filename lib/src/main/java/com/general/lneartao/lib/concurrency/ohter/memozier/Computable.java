package com.general.lneartao.lib.concurrency.ohter.memozier;

/**
 * @author lneartao
 * @date 2018/4/27.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
