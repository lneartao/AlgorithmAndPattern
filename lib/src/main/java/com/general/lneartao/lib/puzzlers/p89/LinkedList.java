package com.general.lneartao.lib.puzzlers.p89;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/4/11.
 */
public class LinkedList<E> {
    private Node head = null;

    // 错误的方式
    /*private class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = head;
            head = this;
        }
    }*/

    private class Node {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
            this.next = head;
            head = this;
        }
    }

    public void add(E e) {
        new Node(e);
    }

    public void dump() {
        for (Node n = head; n != null; n = n.next) {
            Logger.printl(n.value);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("world");
        list.add("hello");
        list.dump();
    }
}
