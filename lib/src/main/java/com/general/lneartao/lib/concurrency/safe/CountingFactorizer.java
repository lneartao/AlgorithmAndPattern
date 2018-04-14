package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子变量计数器
 *
 * @author lneartao
 * @date 2018/4/12.
 */
@ThreadSafe
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void increment() {
        count.incrementAndGet();
    }
}
