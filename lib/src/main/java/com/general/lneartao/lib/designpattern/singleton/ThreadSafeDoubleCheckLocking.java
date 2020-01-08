package com.general.lneartao.lib.designpattern.singleton;

/**
 * Created by lneartao on 2017/11/13.
 */

public class ThreadSafeDoubleCheckLocking {
    private static volatile ThreadSafeDoubleCheckLocking INSTANCE;
    private static boolean flag = true;

    // 防止反射
    private ThreadSafeDoubleCheckLocking() {
        if (flag) {
            flag = false;
        } else {
            throw new AssertionError("Already initialized");
        }
    }

    public static ThreadSafeDoubleCheckLocking getINSTANCE() {
        ThreadSafeDoubleCheckLocking result = INSTANCE;
        if (result == null) {
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
