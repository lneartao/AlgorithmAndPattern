package com.general.lneartao.lib.datastructure;

/**
 * 空的时候指针指向0,满的时候指针指向数组长度,比如16
 * 补一下测试案例吧
 * 插入、增加和查找是O(n)，其余是O(1)
 * Created by lneartao on 2017/11/23.
 */

public class MyVector<E> {
    private Object[] data;
    private int pointer;

    public MyVector() {
        data = new Object[16];
    }

    public MyVector(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
        data = new Object[size];
    }

    public int size() {
        return pointer;
    }

    public int capacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @SuppressWarnings("unchecked")
    public E at(int index) {
        verifyIndex(index);
        return (E) data[index];
    }

    public void push(E item) {
        // 检查是否超过容器大小，超过则扩展
        checkResize();
        data[pointer++] = item;
    }

    private void checkResize() {
        if (pointer >= data.length) {
            resize(data.length * 2);
        } else if (pointer < data.length / 4) {
            resize(data.length / 4);
        }
    }

    public void insert(int index, E item) {
        verifyIndex(index);
        checkResize();
        for (int i = pointer; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        pointer++;
    }

    // 插入item到第一个位置
    public void prepend(E item) {
        insert(0, item);
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new NullPointerException("no content!");
        }
        E result = (E) data[--pointer];
        checkResize();
        return result;
    }

    // 删除某个位置的一个值
    @SuppressWarnings("unchecked")
    public E delete(int index) {
        verifyIndex(index);
        E deleteVal = (E) data[index];
        for (int i = index; i < pointer - 1; i++) {
            data[i] = data[i + 1];
        }
        checkResize();
        pointer--;
        return deleteVal;
    }

    // 删除多个值，比如在多个位置有多个2，也会被删除,这样的效率很不高啊!
    public void remove(E item) {
        for (int i = 0; i < pointer; i++) {
            if (data[i] == item) {
                delete(i);
                i--; // 因为左移了,所以需要重新检查这个位置
            }
        }
    }

    public int find(E item) {
        for (int i = 0; i < pointer; i++) {
            if (item == data[i]) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < Math.min(data.length, newCapacity); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void verifyIndex(int index) {
        if (index >= this.pointer || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + ", length: " + this.pointer);
        }
    }

    public static void main(String[] args) {
        MyVector<Integer> vector = new MyVector<>();
        vector.push(12);
    }
}
