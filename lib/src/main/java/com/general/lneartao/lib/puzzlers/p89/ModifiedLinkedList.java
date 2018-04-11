package com.general.lneartao.lib.puzzlers.p89;

import com.general.lneartao.lib.Logger;

/**
 * 这里说：应该优先使用静态成员类而不是非静态成员类～
 * 真的是这样吗？...
 * 提醒：无论何时你写了一个成员类，都要问问自己，是否这个成员类真的需要使用它的外部类实例？
 * 如果答案是否定的，那么应该把它设为静态成员类
 * 因为内部类和泛型、反射、以及继承都有着复杂的交互方式
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class ModifiedLinkedList<E> {
    private Node head = null;

    private class Node {
        E value;
        Node next;

        public Node(E value) {
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
