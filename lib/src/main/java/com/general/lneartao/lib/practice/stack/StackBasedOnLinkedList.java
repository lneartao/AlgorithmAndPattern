package com.general.lneartao.lib.practice.stack;

/**
 * 基于链表实现栈
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class StackBasedOnLinkedList {

    private Node top = null;

    public void push(int value) {
        top = new Node(value, top);
    }

    public int pop() {
        int result = Integer.MIN_VALUE;
        if (top != null) {
            result = top.data;
            top = top.next;
        }
        return result;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
