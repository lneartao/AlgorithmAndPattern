package com.general.lneartao.lib.datastructure;

/**
 * 数组实现的话，0是不放置任何数据的，其后i节点的儿子分别为2i和2i+1，最小的数值必须在1的位置上
 * 有结构性：完全二叉树
 * 有堆序性：节点必须比儿子小
 * Created by lneartao on 2017/11/27.
 */

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity) {
        this.currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    @SuppressWarnings("unchecked")
    public void insert(AnyType e) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++currentSize;
        for (array[0] = e; e.compareTo(array[hole / 2]) < 0; hole /= 2) {  //array[0]这个可以终止循环
            array[hole] = array[hole / 2];
        }
        array[hole] = e;
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return array[1];
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void clear() {
        currentSize = 0;
    }

    @SuppressWarnings("unchecked")
    private void percolateDown(int hole) {
        int child;
        AnyType temp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && (array[child + 1]).compareTo(array[child]) < 0) {  // 这里只需要假设每个节点都有两个儿子
                child++;
            }
            if ((array[child]).compareTo(temp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = temp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    @SuppressWarnings("unchecked")
    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    public static void main(String[] args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;
        for (; i != 0; i = (i + 37) % numItems) {
            h.insert(i);
        }
        for (i = 1; i < numItems; i++) {
            if (h.deleteMin() != i) {
                System.out.println("Oops! " + i);
            }
        }
    }

}
