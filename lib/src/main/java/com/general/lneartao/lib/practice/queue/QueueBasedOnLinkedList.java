package com.general.lneartao.lib.practice.queue;

/**
 * 基于链表实现的队列
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class QueueBasedOnLinkedList {
    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    public QueueBasedOnLinkedList() {
    }

    public boolean enqueue(String item) {
        Node node = new Node(item, null);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    public String dequeue() {
        if (head == null) {
            return null;
        } else {
            String result = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return result;
        }
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
