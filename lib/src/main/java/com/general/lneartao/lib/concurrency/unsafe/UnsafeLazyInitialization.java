
package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;


/**
 * 不安全的延迟初始化
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/5/8.
 */
@NotThreadSafe
public class UnsafeLazyInitialization {
    private static Resource sResource;

    public static Resource getInstance() {
        if (sResource == null) {
            sResource = new Resource(); // 不安全的发布
        }
        return sResource;
    }

    static class Resource {
    }
}
