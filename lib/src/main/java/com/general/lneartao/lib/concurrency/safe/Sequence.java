package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.unsafe.UnsafeSequence;
import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * @author lneartao
 * @date 2018/4/11.
 * @see UnsafeSequence
 */
@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}
