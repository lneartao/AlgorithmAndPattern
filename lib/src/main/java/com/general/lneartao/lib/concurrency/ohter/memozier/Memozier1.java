package com.general.lneartao.lib.concurrency.ohter.memozier;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用synchronized简单粗暴的进行同步并发
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class Memozier1<A, V> implements Computable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memozier1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

