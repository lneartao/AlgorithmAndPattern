package com.general.lneartao.lib.practice.array;

import java.util.Arrays;

/**
 * 手写数组。实现查找、插入和删除
 *
 * @author lneartao
 * @date 2020/1/9.
 */
public class MyArray {
    private int[] data;
    private int len;
    private int count;

    public MyArray(int capacity) {
        data = new int[capacity];
        len = capacity;
        count = 0;
    }

    public int find(int index) {
        if (!isValid(index)) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (!isValid(index)) {
            return false;
        }
        ensureCapacity();
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    private void ensureCapacity() {
        if (count >= len) {
            len = len * 2 + 1;
            data = Arrays.copyOf(data, len);
        }
    }

    public boolean delete(int index) {
        if (!isValid(index)) {
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    private boolean isValid(int index) {
        return index >= 0 && index < len;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}
