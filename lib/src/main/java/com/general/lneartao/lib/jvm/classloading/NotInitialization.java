package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/5/16.
 */
public class NotInitialization {
    public static void main(String[] args) {
        fun1();
        fun2();
        fun3();
    }

    /**
     * 被动引用例子一：
     * 通过子类引用父类的静态字段，不会导致子类的初始化
     */
    private static void fun1() {
        Logger.printl(SubClass.value);
    }

    /**
     * 被动引用例子二：
     * 通过数组定义来引用类，不会导致类的初始化
     */
    private static void fun2() {
        SuperClass[] ca = new SuperClass[10];
    }

    /**
     * 被动引用例子三：
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
     */
    private static void fun3() {
        Logger.printl(ConstClass.HELLO_WORLD);
    }
}
