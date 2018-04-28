package com.general.lneartao.lib.concurrency.ohter.memozier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 比1的并发性能好，但是有个bug：当两个线程同时调用compute时，可能会导致计算得到相同的值
 * 原因在于compute方法中的if代码块仍然是非原子的先检查后操作
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class Memozier2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memozier2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
