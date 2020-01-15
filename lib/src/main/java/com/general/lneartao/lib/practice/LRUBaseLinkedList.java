package com.general.lneartao.lib.practice;

/**
 * 这种写法是默认有一个头结点
 * 基于单链表LRU算法（java）
 *
 * @author lneartao
 * @date 2020/1/15.
 */
public class LRUBaseLinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void get(T data) {
        SNode<T> pre = findPreNode(data);
        if (pre != null) {
            deleteElemOptim(pre);
            insertElemAtBegin(data);
        } else {
            if (length >= capacity) {
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode节点下一元素
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode<T> preNode) {
        SNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
//        headNode = new SNode<>(data, headNode);
//        length++;
        SNode<T> next = headNode.getNext();
        headNode.setNext(new SNode<>(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     *
     * @return
     */
    private SNode<T> findPreNode(T data) {
        SNode<T> cur = headNode;
        while (cur.getNext() != null) {
            if (data.equals(cur.getNext().getElement())) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode<T> pre = headNode;
        while (pre.getNext() != null && pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        SNode<T> temp = pre.getNext();
        pre.setNext(null);
        temp = null;
        length--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SNode<T> node = headNode.getNext();
        while (node != null) {
            sb.append(node.getElement()).append(",");
            node = node.getNext();
        }
        if (sb.length() > 0) {
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return sb.toString();
        }
    }

    public class SNode<T> {

        private T element;

        private SNode<T> next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode<T> getNext() {
            return next;
        }

        public void setNext(SNode<T> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        testDefaultConstructor();
        testSpecifiedConstructor(4);
    }

    public static void testDefaultConstructor() {
        System.out.println("======无参测试========");
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>();
        lru.get(1);
        lru.get(2);
        lru.get(3);
        lru.get(4);
        lru.get(5);
        System.out.println(lru);
        lru.get(6);
        lru.get(7);
        lru.get(8);
        lru.get(9);
        System.out.println(lru);
    }

    public static void testSpecifiedConstructor(int capacity) {
        System.out.println("======有参测试========");
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>(capacity);
        lru.get(1);
        System.out.println(lru);
        lru.get(2);
        System.out.println(lru);
        lru.get(3);
        System.out.println(lru);
        lru.get(4);
        System.out.println(lru);
        lru.get(2);
        System.out.println(lru);
        lru.get(4);
        System.out.println(lru);
        lru.get(7);
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);
        lru.get(2);
        System.out.println(lru);
    }
}
