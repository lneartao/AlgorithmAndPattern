package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * @author lneartao
 * @date 2018/4/17.
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int val;

    public synchronized int getVal() {
        return val;
    }

    public synchronized void setVal(int val) {
        this.val = val;
    }
}
