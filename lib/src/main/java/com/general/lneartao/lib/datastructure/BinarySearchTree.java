package com.general.lneartao.lib.datastructure;

import java.util.Comparator;

/**
 * Created by lneartao on 2017/11/24.
 */

public class BinarySearchTree<E extends Comparable<? super E>> {
    private BinaryNode<E> root;
    private Comparator<? super E> cmp;
    private int count;  // 节点的数量 不好弄啊～难怪都不加这个获取节点数量的方法

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super E> cmp) {
        root = null;
        this.cmp = cmp;
    }

    public void clear() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    public E findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
        }
        return findMin(root).element;
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
        }
        return findMax(root).element;
    }

    public void insert(E e) {
        root = insert(e, root);
    }

    public void remove(E e) {
        root = remove(e, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree.");
        } else {
            printTree(root);
        }
    }

    private boolean contains(E e, BinaryNode<E> t) {
        if (t == null) {
            return false;
        }
        int compareResult = myCompare(e, t.element);
        if (compareResult < 0) {
            return contains(e, t.left);
        } else if (compareResult > 0) {
            return contains(e, t.right);
        } else {
            return true;
        }
    }

    private int myCompare(E lhs, E rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        } else {
            return lhs.compareTo(rhs);
        }
    }

    // 递归方法
    private BinaryNode<E> findMin(BinaryNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        } else {
            return findMin(t.left);
        }
    }

    // 非递归方法
    private BinaryNode<E> findMax(BinaryNode<E> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    // 关键代码
    private BinaryNode<E> insert(E e, BinaryNode<E> t) {
        if (t == null) {
            return new BinaryNode<>(e, null, null);
        }
        int compareResult = myCompare(e, t.element);
        if (compareResult < 0) {
            t.left = insert(e, t.left);
        } else if (compareResult > 0) {
            t.right = insert(e, t.right);
        }
        return t;
    }

    // 关键代码
    private BinaryNode<E> remove(E e, BinaryNode<E> t) {
        if (t == null) {
            return t; // item not found; do nothing
        }
        int compareResult = myCompare(e, t.element);
        if (compareResult < 0) {
            t.left = remove(e, t.left);
        } else if (compareResult > 0) {
            t.right = remove(e, t.right);
        } else if (t.left != null && t.right != null) {
            // 具有两个儿子的节点
            t.element = findMin(t.right).element; // 找到右子树的最小数据，代替该节点的数据
            t.right = remove(t.element, t.right); // 递归地删除那个节点
        } else {
            // 树叶
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private void printTree(BinaryNode<E> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(BinaryNode<E> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    private static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        public BinaryNode(E element) {
            this(element, null, null);
        }

        public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            t.insert(i);
        }

        for (int i = 1; i < NUMS; i += 2) {
            t.remove(i);
        }

        if (NUMS < 40) {
            t.printTree();
        }
        if (t.findMin() != 2 || t.findMax() != NUMS - 2) {
            System.out.println("FindMin or FindMax error!");
        }

        for (int i = 2; i < NUMS; i += 2) {
            if (!t.contains(i)) {
                System.out.println("Find error1!");
            }
        }

        for (int i = 1; i < NUMS; i += 2) {
            if (t.contains(i)) {
                System.out.println("Find error2!");
            }
        }
    }
}
