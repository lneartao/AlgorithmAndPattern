package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * 提前初始化
 *
 * @author lneartao
 * @date 2018/5/8.
 */
@ThreadSafe
public class EagerInitialization {

    private static Resource sResource = new Resource();

    public static Resource getResource() {
        return sResource;
    }

    static class Resource {

    }
}

