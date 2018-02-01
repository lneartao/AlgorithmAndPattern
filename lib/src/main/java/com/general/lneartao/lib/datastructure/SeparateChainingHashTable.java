package com.general.lneartao.lib.datastructure;

import java.util.LinkedList;
import java.util.List;

import static com.general.lneartao.lib.datastructure.PrimeUtil.nextPrime;

/**
 * 装填因子为1，感觉应该叫HashSet才对，因为这里只允许存储Value，不能自定义Key,不过加以改造的话可以变成HashMap
 * Created by lneartao on 2017/11/24.
 */

public class SeparateChainingHashTable<E> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<E>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < size; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void insert(E x) {
        List<E> whichList = theLists[myHash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            if (++currentSize > theLists.length) {
                rehash();
            }
        }
    }

    public void remove(E x) {
        List<E> whichList = theLists[myHash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(E x) {
        List<E> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        List<E>[] oldLists = theLists;
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int j = 0; j < theLists.length; j++) {
            theLists[j] = new LinkedList<>();
        }
        currentSize = 0;
        for (List<E> list : oldLists) {
            for (E item : list) {
                insert(item);
            }
        }
    }

    // 所以自定义的实体类最好能自定义hashCode()方法
    private int myHash(E x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    public static void main(String[] args) {
        SeparateChainingHashTable<Integer> H = new SeparateChainingHashTable<>();

        long startTime = System.currentTimeMillis();

        final int NUMS = 2000000;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            H.insert(i);
        }
        for (int i = 1; i < NUMS; i += 2) {
            H.remove(i);
        }

        for (int i = 2; i < NUMS; i += 2) {
            if (!H.contains(i)) {
                System.out.println("Find fails " + i);
            }
        }

        for (int i = 1; i < NUMS; i += 2) {
            if (H.contains(i)) {
                System.out.println("OOPS!!! " + i);
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endTime - startTime));
    }

}
