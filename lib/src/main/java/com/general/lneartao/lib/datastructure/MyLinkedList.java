package com.general.lneartao.lib.datastructure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 这里的add和get 末端的index可能会造成混淆
 * 插入、增加是O(1)，其余是O(n)
 * Created by lneartao on 2017/11/23.
 */

public class MyLinkedList<E> {

    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    public MyLinkedList() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
    }

    public void clear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 加到链表末端
    public void pushBack(E item) {
        add(size(), item);
    }

    // 加到链表前端
    public void pushFront(E item) {
        add(0, item);
    }

    public void add(int index, E item) {
//        addBefore(getNode(index),item);         // 这里不能用这个方法,因为可以获得 endMarker
        addBefore(getNode(index, 0, size()), item);
    }

    public E front() {
        return get(0);
    }

    public E back() {
        return get(size() - 1);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) getNode(index);
    }

    public E set(int index, E item) {
        Node<E> oldNode = getNode(index);
        E oldData = oldNode.data;
        oldNode.data = item;
        return oldData;
    }

    public E popFront() {
        return remove(0);
    }

    public E popBack() {
        return remove(size() - 1);
    }

    public E remove(int index) {
        return remove(getNode(index));
    }

    // TODO 似乎有点难
    public void reverse() {

    }

    // 关键代码
    private void addBefore(Node<E> p, E item) {
        Node<E> newNode = new Node<>(item, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    // 关键代码
    private E remove(Node<E> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<E> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    // 关键代码 根据index的位置进行了简单的优化
    private Node<E> getNode(int index, int lower, int upper) {
        Node<E> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
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

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev); // 这里是因为next()把current移到下一位,需要找回当前的节点
            expectedModCount++;
            okToRemove = false;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> lst = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            lst.pushBack(i);
        }
        for (int i = 20; i < 30; i++) {
            lst.add(0, i);
        }

        lst.remove(0);
        lst.remove(lst.size() - 1);

//        Logger.printl(lst);

        java.util.Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            System.out.println(lst);
        }
    }
}
