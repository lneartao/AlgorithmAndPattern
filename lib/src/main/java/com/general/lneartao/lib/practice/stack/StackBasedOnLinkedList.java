package com.general.lneartao.lib.practice.stack;

/**
 * 基于链表实现栈
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class StackBasedOnLinkedList<T> {

    private Node<T> top = null;
    private int size;

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T pop() {
        T result = null;
        if (top != null) {
            result = top.data;
            top = top.next;
            size--;
        }
        return result;
    }

    public int getSize() {
        return size;
    }

    public T getTopData() {
        if (top != null) {
            return top.data;
        }
        return null;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void printAll() {
        Node<T> p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }
}
