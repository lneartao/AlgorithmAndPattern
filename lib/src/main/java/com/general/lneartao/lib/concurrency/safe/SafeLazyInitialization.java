package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * @author lneartao
 * @date 2018/5/8.
 */
@ThreadSafe
public class SafeLazyInitialization {

    private static Resource sResource;

    public synchronized static Resource getInstance() {
        if (sResource == null) {
            sResource = getInstance();
        }
        return sResource;
    }

    static class Resource {

    }
}
