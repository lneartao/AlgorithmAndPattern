package com.general.lneartao.lib.designpattern.singleton;

/**
 * Created by lneartao on 2017/11/13.
 */

public class ThreadSafeDoubleCheckLocking {
    private static volatile ThreadSafeDoubleCheckLocking INSTANCE;

    // 防止反射
    private ThreadSafeDoubleCheckLocking() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static ThreadSafeDoubleCheckLocking getINSTANCE() {
        ThreadSafeDoubleCheckLocking result = INSTANCE;
        if (result == null) {
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                result = INSTANCE;
                if (result == null) {
                    result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
