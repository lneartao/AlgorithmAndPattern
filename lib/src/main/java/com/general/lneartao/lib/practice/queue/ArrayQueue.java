package com.general.lneartao.lib.practice.queue;

/**
 * 用数组实现的队列
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class ArrayQueue {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if (n == tail) {
            return false;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head >= tail) {
            return "";
        }
        return items[head++];
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
