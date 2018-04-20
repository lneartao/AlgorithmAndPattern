package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

/**
 * @author lneartao
 * @date 2018/4/17.
 * @see com.general.lneartao.lib.concurrency.safe.SynchronizedInteger
 */
@NotThreadSafe
public class MutableInteger {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
