package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * 字段解析
 *
 * @author lneartao
 * @date 2018/5/16.
 */
public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        // 注释这一段会拒绝编译
        public static int A = 4;
    }

    public static void main(String[] args) {
        Logger.printl(Sub.A);
    }
}
