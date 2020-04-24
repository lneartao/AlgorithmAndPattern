package com.general.lneartao.lib.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

/**
 * 集合中添加软引用的正确做法
 * <p>
 * java -Xms4M -Xms4M -Xmn2M SoftReferenceTest
 *
 * @author lneartao
 * @date 2020/4/1.
 */
public class SoftReferenceTest {
    public static class SoftObject {
        byte[] data = new byte[1024];
    }

    public static int removeSoftRefs = 0;
    public static int CACHE_INITIAL_CAPACITY = 100 * 1024;
    // 静态集合中保存软引用，会导致这些软引用对象本身无法被垃圾回收器回收
    public static Set<SoftReference<SoftObject>> cache = new HashSet<>(CACHE_INITIAL_CAPACITY);
    private static ReferenceQueue<SoftObject> referenceQueue = new ReferenceQueue<>();

    public static void main(String[] args) {
        for (int i = 0; i < CACHE_INITIAL_CAPACITY; i++) {
            SoftObject object = new SoftObject();
            cache.add(new SoftReference<>(object, referenceQueue));
            clearUselessReferences();
            if (i % 10000 == 0) {
                System.out.println("size of cache " + cache.size());
            }
        }
        System.out.println("End, removed soft references = " + removeSoftRefs);
    }

    public static void clearUselessReferences() {
        Reference<? extends SoftObject> ref = referenceQueue.poll();
        while (ref != null) {
            if (cache.remove(ref)) {
                removeSoftRefs++;
            }
            ref = referenceQueue.poll();
        }
    }
}
