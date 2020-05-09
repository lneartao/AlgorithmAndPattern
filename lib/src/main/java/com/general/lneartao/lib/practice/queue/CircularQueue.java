package com.general.lneartao.lib.practice.queue;

/**
 * 循环单端队列
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        } else {
            items[tail] = item;
            tail = (tail + 1) % n;
            return true;
        }
    }

    public String dequeue() {
        if (head >= tail) {
            return null;
        } else {
            String result = items[head];
            head = (head + 1) % n;
            return result;
        }
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % n == head;
    }

    public void printAll() {
        if (0 == n) {
            return;
        }
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
