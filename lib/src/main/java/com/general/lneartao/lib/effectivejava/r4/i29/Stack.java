package com.general.lneartao.lib.effectivejava.r4.i29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 优先考虑泛型
 * <p>
 * 转换泛型的两种方法：
 * 1. 在构造器创建数组的时候就进行转换，这种方式会导致堆污染，详见第32条，虽然堆污染在这种情况下并没有什么危害
 * 2. 每次读取一个数组元素时都转换一次，elements保持Object[] {@link java.util.ArrayList#elementData}
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 方法一
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
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
