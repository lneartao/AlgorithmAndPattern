package com.general.lneartao.lib.effectivejava.r1.i4;

/**
 * 通过私有构造器强化不可实例化的能力
 * 一般这种情况都是用于只包含静态域和静态方法的工具类
 *
 * @author lneartao
 * @date 2020/1/7.
 */
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError("Already initialized");
    }
}
