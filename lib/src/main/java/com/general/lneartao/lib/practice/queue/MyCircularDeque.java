package com.general.lneartao.lib.practice.queue;

/**
 * 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 *
 * @author lneartao
 * @date 2020/5/7.
 */
public class MyCircularDeque {
    private int[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        items = new int[k + 1];
        n = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            head = (head - 1 + n) % n;
            items[head] = value;
            return true;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            items[tail] = value;
            tail = (tail + 1) % n;
            return true;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % n;
            return true;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            tail = (tail - 1 + n) % n;
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return items[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return items[((tail - 1 + n) % n)];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return tail == head;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % n == head;
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        MyCircularDeque circularDeque = new MyCircularDeque(4);
        circularDeque.insertFront(9);
        circularDeque.deleteLast();
        circularDeque.getRear();
        circularDeque.getFront();
        circularDeque.getFront();
        circularDeque.deleteFront();
        circularDeque.insertFront(6);
        circularDeque.insertLast(5);
        circularDeque.insertFront(9);
        circularDeque.getFront();
        circularDeque.insertFront(6);
    }

    private static void test1() {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(4);                    // 已经满了，返回 false
        circularDeque.getRear();                // 返回 2
        circularDeque.isFull();                        // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.insertFront(4);                    // 返回 true
        circularDeque.getFront();                // 返回 4
    }

}
