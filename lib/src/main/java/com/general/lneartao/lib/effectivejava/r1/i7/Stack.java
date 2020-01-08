package com.general.lneartao.lib.effectivejava.r1.i7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 清除过期的对象引用
 * <p>
 * 下面的例子在java内库中也是使用同样的处理办法
 * {@link java.util.Vector#removeElementAt(int)}
 * {@link java.util.ArrayList#remove(int)}
 * 一般情况下，我们应该相信java的垃圾回收器，下面有三种情况需要特别注意：
 * 1. 只要类是自己管理内存，那么就应该警惕内存泄漏的问题
 * 2. 缓存--把对象引用放到缓存中，但是此后很长一段时间都没有使用，一直留在缓存中。考虑使用弱引用
 * 3. 监听器和其他回调，考虑使用弱引用，同时注意取消注册
 *
 * @author lneartao
 * @date 2020/1/8.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // 当栈先增长，后收缩，这里会发生内存泄漏
        return elements[--size];
        // 修改的方法是
//        Object result = elements[--size];
//        elements[size] = null;
//        return result;
    }

    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
