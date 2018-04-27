package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * toString(), hashCode(), equals(), containsAll(), removeAll(), retainAll()都有可能包含隐藏迭代器
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/25.
 */
public class HiddenIterator {
    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        // 这里toString()方法会对容器进行迭代，然后就可能抛出ConcurrentModificationException，这里就时隐藏的迭代器
        System.out.println("Debug: added ten elements to " + set);
    }


}
