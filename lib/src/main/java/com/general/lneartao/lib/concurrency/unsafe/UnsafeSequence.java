package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;
import com.general.lneartao.lib.concurrency.safe.Sequence;

/**
 * value++不是单个操作，它实际上包含三个独立操作：读取value，将value加1，并将计算结果写入value
 * 原因：由于运行时可能将多个线程之间的操作交替执行，因此这两个线程可能同时执行该读操作，从而使它们得到相同的值，并都将这个值加1
 * 修正版本 {@link Sequence}
 *
 * @author lneartao
 * @date 2018/4/11.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * 返回一个唯一的数值
     *
     * @return
     */
    public int getNext() {
        return value++;
    }
}
