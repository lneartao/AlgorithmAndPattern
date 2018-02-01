package com.general.lneartao.lib.datastructure;

/**
 * Created by lneartao on 2017/11/24.
 */

public class QuadraticProbingHashTable<E> {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<E>[] array;
    private int currentSize;
    private int occupied; // the number of occupied cells

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int currentSize) {
        allocateArray(currentSize);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public int size() {
        return currentSize;
    }

    public int capacity() {
        return array.length;
    }

    public boolean contains(E e) {
        int currentPos = findPos(e);
        return isActive(currentPos);
    }

    public boolean insert(E e) {
        int currentPos = findPos(e);
        if (isActive(currentPos)) {
            return false;
        }
        if (array[currentPos] == null) {
            ++occupied;
        }
        array[currentPos] = new HashEntry<>(e, true);
        currentSize++;
        if (occupied > array.length / 2) {
            rehash();
        }
        return true;
    }

    public boolean remove(E e) {
        int currentPos = findPos(e);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
            currentSize--;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        array = new HashEntry[PrimeUtil.nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(E e) {
        int offset = 1;
        int currentPos = myHash(e);
        while (array[currentPos] != null &&
                !array[currentPos].element.equals(e)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private void rehash() {
        HashEntry<E>[] oldArray = array;
        allocateArray(2 * oldArray.length);
        occupied = 0;
        currentSize = 0;
        for (HashEntry<E> entry : oldArray) {
            if (entry != null && entry.isActive) {
                insert(entry.element);
            }
        }
    }

    private int myHash(E e) {
        int hashVal = e.hashCode();

        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }

        return hashVal;
    }

    private static class HashEntry<E> {
        public E element;
        public boolean isActive;

        public HashEntry(E element) {
            this(element, true);
        }

        public HashEntry(E element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable<String> H = new QuadraticProbingHashTable<>();


        long startTime = System.currentTimeMillis();

        final int NUMS = 2000000;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");


        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            H.insert("" + i);
        }
        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            if (H.insert("" + i)) {
                System.out.println("OOPS!!! " + i);
            }
        }
        for (int i = 1; i < NUMS; i += 2) {
            H.remove("" + i);
        }

        for (int i = 2; i < NUMS; i += 2) {
            if (!H.contains("" + i)) {
                System.out.println("Find fails " + i);
            }
        }

        for (int i = 1; i < NUMS; i += 2) {
            if (H.contains("" + i)) {
                System.out.println("OOPS!!! " + i);
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endTime - startTime));
    }
}

