package com.general.lneartao.lib.datastructure;

/**
 * Created by lneartao on 2017/11/27.
 */

public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {

    private Node<AnyType> root;

    public LeftistHeap() {
        root = null;
    }

    public void merge(LeftistHeap<AnyType> rhs) {
        if (this == rhs) {
            return;
        }
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x) {
        root = merge(new Node<>(x), root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return root.element;
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        AnyType minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t) {
        Node<AnyType> temp = t.left;
        t.left = t.right;
        t.right = temp;
    }

    private static class Node<AnyType> {
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;

        public Node(AnyType element) {
            this(element, null, null);
        }

        public Node(AnyType element, Node<AnyType> left, Node<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            npl = 0;
        }
    }

    public static void main(String[] args) {
        int numItems = 100;
        LeftistHeap<Integer> h = new LeftistHeap<>();
        LeftistHeap<Integer> h1 = new LeftistHeap<>();
        int i = 37;

        for (; i != 0; i = (i + 37) % numItems) {
            if (i % 2 == 0) {
                h1.insert(i);
            } else {
                h.insert(i);
            }
        }

        h.merge(h1);
        for (i = 1; i < numItems; i++) {
            if (h.deleteMin() != i) {
                System.out.println("Oops! " + i);
            }
        }
    }
}
