package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 如果打算在多线程中创建实例，要么将对实例计数器的访问进行同步，要么使用一个AtomicLong（防止int溢出）类型的计数器
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P55 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Creature();
        }
        Logger.printl(Creature.getNumCreated());
    }
}

/**
 * 这不是线程安全的
 */
class Creature {
    private static long numCreated = 0;

    public Creature() {
        numCreated++;
    }

    public static long getNumCreated() {
        return numCreated;
    }
}

/**
 * 这是线程安全的
 */
class ModifiedCreature {
    private static long numCreated;

    public ModifiedCreature() {
        synchronized (Creature.class) {
            numCreated++;
        }
    }

    public static synchronized long getNumCreated() {
        return numCreated;
    }
}

/**
 * 使用了Atomic方法的线程同步
 */
class ModifiedCraeture2 {
    private static AtomicLong numCreated = new AtomicLong();

    public ModifiedCraeture2() {
        numCreated.incrementAndGet();
    }

    public static long getNumCreated() {
        return numCreated.get();
    }
}
