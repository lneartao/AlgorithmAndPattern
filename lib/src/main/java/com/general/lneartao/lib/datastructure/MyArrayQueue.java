package com.general.lneartao.lib.datastructure;

/**
 * 都是O(1)
 * Created by lneartao on 2017/11/23.
 */

public class MyArrayQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int currentSize;
    private int front;
    private int back;
    private int capacity;

    public MyArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayQueue(int capacity) {
        data = new Object[capacity];
        currentSize = 0;
        front = 0;
        back = 0;
        this.capacity = capacity;
    }

    public void enqueue(E value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        data[back] = value;
        currentSize++;
        back = (back + 1) % capacity;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E value = (E) data[front];
        currentSize--;
        front = (front + 1) % capacity;
        return value;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }
}
