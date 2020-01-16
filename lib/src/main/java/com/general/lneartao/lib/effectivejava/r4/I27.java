package com.general.lneartao.lib.effectivejava.r4;

import java.util.Arrays;

/**
 * 消除非受检的警告
 * 尽可能地消除非受检的警告，可以使用菱形操作符<>，编译器会推测出正确的实际类型参数。
 * 如果无法消除警告，同时可以证明引起警告的代码是类型安全的，才可用用一个@SuppressWarnings("unchecked")注解来禁止这条警告，
 * 而且应该始终在尽可能小的范围内使用这个注解，最好的变量声明。每当使用这个注解时，都要添加一条注解，说明为什么这么做是安全的。
 * 比如 {@link java.util.ArrayList#toArray(Object[])} 应该改写成下面会更棒。
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public class I27 {

    private int size;
    private transient Object[] elementData;

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Make a new array of a's runtime type, but my contents:
            @SuppressWarnings("unchecked") T[] result =
                    (T[]) Arrays.copyOf(elementData, size, a.getClass());
            return result;
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
