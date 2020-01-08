package com.general.lneartao.lib.effectivejava.r1.i3;

import java.io.Serializable;

/**
 * 用私有构造器或者枚举类型强化Singleton属性
 *
 * @author lneartao
 * @date 2020/1/7.
 */
public class PrivateEagerElvis implements Serializable {
    private static final PrivateEagerElvis INSTANCE = new PrivateEagerElvis();
    private static boolean flag = true;

    /**
     * 防止反射机制调用私有构造器
     */
    private PrivateEagerElvis() {
        if (flag) {
            flag = false;
        } else {
            throw new AssertionError("Already initialized");
        }
    }

    public PrivateEagerElvis getInstance() {
        return INSTANCE;
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
