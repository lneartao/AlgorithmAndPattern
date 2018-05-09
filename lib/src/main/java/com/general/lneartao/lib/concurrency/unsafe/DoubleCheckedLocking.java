package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

/**
 * 双重检查加锁：问题是线程可能看到引用的当前值，但对象的状态值却是失效的
 * 这里加上volatile在5.0后可以启用DCL，但是使用延迟初始化占位类模式也能带来同样的优势
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/5/8.
 * @see com.general.lneartao.lib.concurrency.safe.ResourceFactory
 */
@NotThreadSafe
public class DoubleCheckedLocking {

    private static Resource sResource;

    public static Resource getInstance() {
        if (sResource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (sResource == null) {
                    sResource = new Resource();
                }
            }
        }
        return sResource;
    }

    static class Resource {

    }
}
