package com.general.lneartao.lib.effectivejava.r1.i3;

import java.io.Serializable;

/**
 * @author lneartao
 * @date 2020/1/7.
 */
public class PublicEagerElvis implements Serializable {
    public static final PublicEagerElvis INSTANCE = new PublicEagerElvis();
    private static boolean flag = true;

    /**
     * 防止反射机制调用私有构造器
     */
    private PublicEagerElvis() {
        if (flag = true) {
            flag = false;
        } else {
            throw new AssertionError("Already initialized");
        }
    }

    /**
     * 防止序列化创建新的实例
     *
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
