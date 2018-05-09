package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.Immutable;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子变量似乎一种“更好的volatile”
 * 通过CAS来维持包含多个变量的不变性条件
 *
 * @author lneartao
 * @date 2018/5/2.
 */
@ThreadSafe
public class CasNumberRange {

    @Immutable
    private static class IntPair {
        final int lower;
        final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldV = values.get();
            if (i > oldV.upper) {
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            }
            IntPair newV = new IntPair(i, oldV.upper);
            if (values.compareAndSet(oldV, newV)) {
                return;
            }
        }
    }

    public void setUpper(int i) {
        while (true) {
            IntPair oldV = values.get();
            if (i < oldV.lower) {
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            }
            IntPair newV = new IntPair(oldV.lower, i);
            if (values.compareAndSet(oldV, newV)) {
                return;
            }
        }
    }
}
