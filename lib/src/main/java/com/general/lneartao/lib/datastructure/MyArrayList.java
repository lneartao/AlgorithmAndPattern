package com.general.lneartao.lib.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 插入、增加是O(n)，其余是O(1)
 * Created by lneartao on 2017/11/23.
 */

public class MyArrayList<E> {
    private static final int DEFAULT_CAPCITY = 10;
    private int pointer;
    private Object[] data;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPCITY];
    }

    public MyArrayList(int pointer) {
        if (pointer < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + pointer);
        }
        data = new Object[pointer];
    }

    // 这里可以重置数组长度,也可以把数组的值都置为null,或者只是把指针重置也可以
    public void clear() {
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        verifyIndex(index);
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E item) {
        verifyIndex(index);
        E oldVal = (E) data[index];
        data[index] = item;
        return oldVal;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < pointer) {
            return;
        }
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void add(E item) {
        if (size() >= data.length) {
            ensureCapacity(data.length * 2 + 1);
        }
        data[pointer++] = item;
    }

    public void add(int index, E item) {
        verifyIndex(index);
        if (size() >= data.length) {
            ensureCapacity(data.length * 2 + 1);
        }
        for (int i = size(); i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        pointer++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        verifyIndex(index);
        E result = (E) data[index];
        for (int i = index; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        pointer--;
        return result;
    }

    private void verifyIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + ", length: " + size());
        }
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        int current = 0;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            okToRemove = true;
            return (E) data[current++];
        }

        @Override
        public void remove() {
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(--current);
            okToRemove = false;
        }
    }
}
