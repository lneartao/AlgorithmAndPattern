package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * Nonblocking counter using CAS
 *
 * @author lneartao
 * @date 2018/5/2.
 */
@ThreadSafe
public class CasCounter {
    private SimulatedCAS val;

    public int getVal() {
        return val.get();
    }

    public int increment() {
        int v;
        do {
            v = val.get();
        } while (v != val.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
