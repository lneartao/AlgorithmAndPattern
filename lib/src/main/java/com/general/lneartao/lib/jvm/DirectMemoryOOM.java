package com.general.lneartao.lib.jvm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 使用unsafe分配本机内存，导致本机直接内存溢出
 *
 * @author lneartao
 * @date 2018/5/14.
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
