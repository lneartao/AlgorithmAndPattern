package com.general.lneartao.lib.datastructure;

/**
 * 因为用的是LinkedList的实现方法，所以所有方法都是O(1)
 * 也可以直接用MyLinkedList的实现
 * Created by lneartao on 2017/11/23.
 */

public class MyListQueue<E> {
    private Node<E> beginMarker;
    private Node<E> endMarker;
    private int theSize;

    public MyListQueue() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(E val) {
        addBefore(getNode(size()), val);
    }

    // 关键代码
    private void addBefore(Node<E> p, E item) {
        Node<E> newNode = new Node<>(item, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return remove(getNode(0));
    }

    // 关键代码
    private E remove(Node<E> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        return p.data;
    }

    private Node<E> getNode(int index) {
        Node<E> p;
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return theSize;
    }

    private static class Node<E> {
        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }
    }
}
