package com.general.lneartao.lib.jvm;

/**
 * @author lneartao
 * @date 2018/5/15.
 */
public class AllocationRAM {
    private static final int _1MB = 1024 * 1024;

    /**
     * 对象分配在Eden区
     */
    public static void testALlocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 大对象直接进入老年代
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * 长期存活的对象进入老年代
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB * 4];

        // 什么时候进入老年代取决于 XX:MaxTenuringThreshold设置，等于默认值15的时候进入老年代
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * 动态对象年龄判断：如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半
     * 年龄大于或等于该年龄的对象就可以直接进入老年代，无须等到MaxTenuringThreshold中要求的年龄
     */
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB * 4];
        // allocation1+allocation2大于surviror空间的一半
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 空间分配担保：jdk6u24后，只要老年代的连续空间大于新生代对象总大小或历次晋升的平均大小就会进行MinorGC，否则进行FullGC
     */
    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        // allocation1+allocation2大于surviror空间的一半
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;

        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }


}
