package com.general.lneartao.lib.concurrency.ohter.memozier;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 这里使用了putIfAbsent()原子方法避免了3中的问题
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class Memozier<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memozier(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> callable = () -> c.compute(arg);
                FutureTask<V> t = new FutureTask<>(callable);
                f = cache.putIfAbsent(arg, t);
                if (f == null) {
                    f = t;
                    t.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                return null;
            }
        }
    }
}
