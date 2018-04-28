package com.general.lneartao.lib.concurrency.ohter.memozier;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 并发比2好，但仍有缺陷，还是跟2一样的问题，但是发生的概率远小于2中发生的概率
 * 原因在于compute方法中的if代码块仍然是非原子的先检查后操作
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class Memozier3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memozier3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> callable = () -> c.compute(arg);
            FutureTask<V> t = new FutureTask<>(callable);
            f = t;
            cache.put(arg, f);
            t.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            return null;
        }
    }
}
