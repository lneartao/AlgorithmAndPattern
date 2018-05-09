package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * 延长初始化占位类模式
 *
 * @author lneartao
 * @date 2018/5/8.
 */
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        private static Resource sResource = new Resource();
    }

    public static Resource getResource() {
        return ResourceHolder.sResource;
    }

    static class Resource {

    }
}
