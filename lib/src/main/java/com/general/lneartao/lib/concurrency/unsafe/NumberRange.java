package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Number range class that does not sufficiently protect its invariants
 * 如果某个类含有复合操作，那么仅靠委托可能并不足以实现线程安全性
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/25.
 */
@NotThreadSafe
public class NumberRange {
    // 不变性: lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // Warning -- unsafe check-then-act
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning -- unsafe check-then_act
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
