package com.general.lneartao.lib.practice.queue;

/**
 * @author lneartao
 * @date 2020/1/20.
 */
public class DynamicArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了
        if (n == tail) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            // 数据搬移
            if (tail - head >= 0) {
                System.arraycopy(items, head, items, 0, tail - head);
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
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
