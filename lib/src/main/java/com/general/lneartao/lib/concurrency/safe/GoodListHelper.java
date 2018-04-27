package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/4/25.
 * @see com.general.lneartao.lib.concurrency.unsafe.BadListHelper
 */
@ThreadSafe
public class GoodListHelper<E> {
    private List<E> mEList = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x) {
        synchronized (mEList) {
            boolean absent = !mEList.contains(x);
            if (absent) {
                mEList.add(x);
            }
            return absent;
        }
    }
}
