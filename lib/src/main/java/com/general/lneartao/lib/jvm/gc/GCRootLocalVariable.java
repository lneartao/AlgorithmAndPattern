package com.general.lneartao.lib.jvm.gc;

/**
 * 验证虚拟机栈（栈帧中的局部变量）中的引用对象可以作为GC Root
 *
 * @author lneartao
 * @date 2020/4/1.
 */
public class GCRootLocalVariable {
    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) {
        System.out.println("开始");
        printMemory();
        method();
        System.gc();
        // 第二次GC，局部变量g跟随方法消失，不再有引用类型指向该80M对象，所有第一次GC后次80M也会被回收
        System.out.println("第二次GC完成");
        printMemory();
    }

    public static void method() {
        GCRootLocalVariable g = new GCRootLocalVariable();
        System.gc();
        System.out.println("第一次GC完成");
        printMemory();
    }

    /**
     * 打印当前JVM剩余空间和总的空间大小
     */
    public static void printMemory() {
        System.out.println("free is " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " M");
        System.out.println("total is " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + " M");
    }
}
