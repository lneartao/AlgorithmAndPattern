package com.general.lneartao.lib.practice;

/**
 * 单链表的插入、删除、查找操作；
 * 提示：头结点要特殊考虑一下
 *
 * @author lneartao
 * @date 2020/1/10.
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node cur = head;
        while (cur != null && cur.data != value) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findByIndex(int index) {
        Node cur = head;
        int pos = 0;
        while (cur != null && pos != index) {
            cur = cur.next;
            pos++;
        }
        return cur;
    }

    /**
     * 无头结点
     * 表头部插入
     * 这种操作将于输入的顺序相反，逆序
     *
     * @param value
     */
    public void insertToHead(int value) {
        insertToHead(createNode(value));
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 顺序插入
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = createNode(value);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            // 这句似乎没用
            newNode.next = cur.next;

            cur.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        insertAfter(p, createNode(value));
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        insertBefore(p, createNode(value));
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            insertToHead(newNode);
            return;
        }
        // 1. 找到p的位置
        Node cur = head;
        while (cur != null && cur.next != p) {
            cur = cur.next;
        }
        // 没找到p
        if (cur == null) {
            return;
        }
        // 2. 插入newNode
        newNode.next = p;
        cur.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        if (head == p) {
            head = head.next;
            return;
        }
        Node cur = head;
        while (cur != null && cur.next != p) {
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    public void deleteByValue(int value) {
//        if (head == null) {
//            return;
//        }
//        Node cur = head;
//        Node prev = null;
//        while (cur != null && cur.data != value) {
//            prev = cur;
//            cur = cur.next;
//        }
//        if (cur == null) {
//            return;
//        }
//        if (prev == null) {
//            head = head.next;
//        } else {
//            prev.next = prev.next.next;
//        }

        // 可重复删除指定value的代码
        if (head != null && head.data == value) {
            head = head.next;
        }
        Node pNode = head;
        while (pNode != null) {
            if (pNode.next != null && pNode.next.data == value) {
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }
    }

    /**
     * 判断true or false
     * 每个节点的值都相等
     *
     * @param left
     * @param right
     *
     * @return
     */
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;
        boolean flag = true;
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断是否为回文
     *
     * @return
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        }
        // 寻找中心节点
        Node p = head;
        Node q = head;
        // 只有一个节点
        if (p.next == null) {
            return true;
        }
        // 有多个节点
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        Node left = null;
        Node right = null;
        if (q.next == null) {
            // p一定为整个链表的中点，且节点数目为奇数
            right = p.next;
            left = inverseLinkList(p).next;
        } else {
            right = p.next;
            left = inverseLinkList(p);
        }
        return TFResult(left, right);
    }

    /**
     * 无头结点的链表翻转
     *
     * @param p
     *
     * @return
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        Node next = null;
        while (r != p) {
            // 保存原逻辑的next
            next = r.next;
            // 保存翻转逻辑的next
            r.next = pre;
            // 缓存翻转逻辑的next
            pre = r;
            // 前进原逻辑的next,最终会前进到p，作为翻转后的头节点
            r = next;
        }
        // 纠正最后一次的next指向
        r.next = pre;
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
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

    public void printAll() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
//        int data[] = {1};
//        int data[] = {1, 2};
//        int data[] = {1,2,3,1};
//        int data[] = {1,2,5};
//        int data[] = {1,2,2,1};
         int data[] = {1,2,5,2,1};
//        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

//        Node p = link.inverseLinkList(link.findByValue(3));
//        while (p != null) {
//            System.out.print(p.data);
//            p = p.next;
//        }
        link.deleteByValue(2);
        link.printAll();
//
//        System.out.println("打印原始:");
//        link.printAll();
//        if (link.palindrome()) {
//            System.out.println("回文");
//        } else {
//            System.out.println("不是回文");
//        }
    }
}
