package com.general.lneartao.lib.datastructure;

import java.util.Random;

/**
 * Created by lneartao on 2017/11/24.
 */

public class CuckooHashTable<E> {
    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super E> hashFunctions;
    private final int numHashFunctions;
    private E[] array;
    private int currentSize;

    public CuckooHashTable(HashFamily<? super E> hashFamily) {
        this(hashFamily, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super E> hashFunctions, int size) {
        allocateArray(PrimeUtil.nextPrime(size));
        doClear();
        this.hashFunctions = hashFunctions;
        numHashFunctions = hashFunctions.getNumberOfFunctions();
    }

    public void makeEmpty() {
        doClear();/**/
    }

    public boolean contains(E e) {
        return findPos(e) != -1;
    }

    private int myHash(E e, int which) {
        int hashVal = hashFunctions.hash(e, which);
        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private int findPos(E e) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myHash(e, i);
            if (array[pos] != null && array[pos].equals(e)) {
                return pos;
            }
        }
        return -1;
    }

    public boolean remove(E e) {
        int pos = findPos(e);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    public boolean insert(E e) {
        if (contains(e)) {
            return false;
        }
        if (currentSize >= array.length * MAX_LOAD) {
            expand();
        }
        return insertInternal(e);
    }

    private int rehashes = 0;
    private Random r = new Random();

    private boolean insertInternal(E e) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myHash(e, i);
                    if (array[pos] == null) {
                        array[pos] = e;
                        currentSize++;
                        return true;
                    }
                }

                // none of the spots are available. Kick out a random one
                int i = 0;
                do {
                    pos = myHash(e, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);
                E temp = array[lastPos = pos];
                array[pos] = e;
                e = temp;
            }
            if (++rehashes > ALLOWED_REHASHES) {
                expand();
                rehashes = 0;
            } else {
                rehash();
            }
        }
    }

    private boolean insertInternal2(E e) {
        final int COUNT_LIMIT = 100;
        while (true) {
            for (int count = 0; count < COUNT_LIMIT; count++) {
                int pos = myHash(e, count % numHashFunctions);
                E temp = array[pos];
                array[pos] = e;
                if (temp == null) {
                    return true;
                } else {
                    e = temp;
                }
            }
            if (++rehashes > ALLOWED_REHASHES) {
                expand();
                rehashes = 0;
            } else {
                rehash();
            }
        }
    }

    public void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLenght) {
        E[] oldArray = array;
        allocateArray(PrimeUtil.nextPrime(newLenght));
        currentSize = 0;
        for (E str : oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    public int size(){
        return currentSize;
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public int capacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        array = (E[]) new Object[arraySize];
    }

    public static void main(String[] args) {
        long cumulative = 0;

        final int NUMS = 2000000;
        final int GAP = 37;
        final int ATTEMPTS = 10;

        System.out.println("Checking... (no more output means success)");

        for (int att = 0; att < ATTEMPTS; att++) {
            System.out.println("ATTEMPT: " + att);

            CuckooHashTable<String> H = new CuckooHashTable<>(new StringHashFamily(3));
            //QuadraticProbingHashTable<String> H = new QuadraticProbingHashTable<>( );

            long startTime = System.currentTimeMillis();

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

            cumulative += endTime - startTime;

            if (H.capacity() > NUMS * 4) {
                System.out.println("LARGE CAPACITY " + H.capacity());
            }
        }

        System.out.println("Total elapsed time is: " + cumulative);
    }
}
