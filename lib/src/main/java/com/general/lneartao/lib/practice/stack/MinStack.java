package com.general.lneartao.lib.practice.stack;

/**
 * LeetCode 155. Min Stack
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class MinStack {

    private Node top;
    private Node min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        top = null;
        min = null;
    }

    public void push(int x) {
        Node node = new Node(x, top);
        top = node;
        if (min == null) {
            min = node;
        } else if (min.data > x) {
            min = node;
        }
    }

    public void pop() {
        if (top != null) {
            Node delete = top;
            top = top.next;
            if (delete == min) {
                min = top;
                Node cur = top;
                while (cur != null) {
                    if (min.data > cur.data) {
                        min = cur;
                    }
                    cur = cur.next;
                }
            }
        }
    }

    public int top() {
        if (top != null) {
            return top.data;
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if (min != null) {
            return min.data;
        }
        return Integer.MIN_VALUE;
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

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
