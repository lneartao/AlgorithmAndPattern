package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lneartao
 * @date 2018/4/25.
 * @see com.general.lneartao.lib.concurrency.safe.GoodListHelper
 */
@NotThreadSafe
public class BadListHelper<E> {
    public List<E> mEList = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !mEList.contains(x);
        if (absent) {
            mEList.add(x);
        }
        return absent;
    }
}
