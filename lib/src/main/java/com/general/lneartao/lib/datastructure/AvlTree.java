package com.general.lneartao.lib.datastructure;

/**
 * 在二叉查找树的基础上，在每次的插入和删除的时候都平衡树
 *
 * @author lneartao
 * @date 2017/11/25
 */

public class AvlTree<E extends Comparable<? super E>> {

    private AvlNode<E> root;

    public AvlTree() {
        root = null;
    }

    public void insert(E e) {
        root = insert(e, root);
    }

    private AvlNode<E> insert(E e, AvlNode<E> t) {
        if (t == null) {
            return new AvlNode<>(e);
        }
        int compareResult = e.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(e, t.left);
        } else if (compareResult > 0) {
            t.right = insert(e, t.right);
        }
        return balance(t);
    }

    public void remove(E e) {
        root = remove(e, root);
    }

    private AvlNode<E> remove(E e, AvlNode<E> t) {
        if (t == null) {
            return t;
        }
        int compareResult = e.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(e, t.left);
        } else if (compareResult > 0) {
            t.right = remove(e, t.right);
        } else if (t.right != null && t.left != null) {
            t.element = findMin(t.right).element;
            t.right = remove(e, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, AvlNode<E> t) {
        while (t != null) {
            int compareResult = e.compareTo(t.element);
            if (compareResult < 0) {
                t = t.left;
            } else if (compareResult > 0) {
                t = t.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public E findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
        }
        return findMin(root).element;
    }

    private AvlNode<E> findMin(AvlNode<E> t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
        }
        return findMax(root).element;
    }

    private AvlNode<E> findMax(AvlNode<E> t) {
        if (t == null) {
            return t;
        }
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        }
        printTree(root);
    }

    private void printTree(AvlNode<E> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<E> balance(AvlNode<E> t) {
        if (t == null) {
            return t;
        }
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            // 为了考虑删除时Y树和X树的一样深度的情况，用单旋转就足以解决问题了
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode<E> t) {
        if (t == null) {
            return -1;
        }
        int hl = checkBalance(t.left);
        int hr = checkBalance(t.right);
        if (Math.abs(height(t.left) - height(t.right)) > 1 ||
                height(t.left) != hl || height(t.right) != hr) {
            System.out.println("OOPS!!");
        }
        return height(t);
    }

    private int height(AvlNode<E> t) {
        return t == null ? -1 : t.height;
    }

    // k2的右边和k1的左边是不变的，现在k2的左边是k1的右子树，k1的右边是k2
    private AvlNode<E> rotateWithLeftChild(AvlNode<E> k2) {
        AvlNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<E> rotateWithRightChild(AvlNode<E> k1) {
        AvlNode<E> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    // 右-左双旋转还是难以理解
    private AvlNode<E> doubleWithLeftChild(AvlNode<E> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<E> doubleWithRightChild(AvlNode<E> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private static class AvlNode<E> {
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;

        public AvlNode(E element) {
            this(element, null, null);
        }

        public AvlNode(E element, AvlNode<E> left, AvlNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }

    private static void test2() {
        AvlTree<Integer> t = new AvlTree<>();
        for (int i = 0; i < 10; i++) {
            t.insert(i);
        }
        t.printTree();
    }

    private static void test1() {
        AvlTree<Integer> t = new AvlTree<>();
        final int SMALL = 40;
        final int NUMS = 1000000;  // must be even
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
//                System.out.println( "INSERT: " + i );
            t.insert(i);
            if (NUMS < SMALL) {
                t.checkBalance();
            }
        }

        for (int i = 1; i < NUMS; i += 2) {
//               System.out.println( "REMOVE: " + i );
            t.remove(i);
            if (NUMS < SMALL) {
                t.checkBalance();
            }
        }
        if (NUMS < SMALL) {
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
