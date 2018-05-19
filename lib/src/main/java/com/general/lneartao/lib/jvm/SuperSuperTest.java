package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 为什么没有输出 i am grandfather!!!
 *
 * @author lneartao
 * @date 2018/5/18.
 */
public class SuperSuperTest {

    class GrandFather {
        void thinking() {
            Logger.printl("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            Logger.printl("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            // 如果不用方法调用，无法调用GrandFather的thinking()方法
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {

            }
        }
    }

    public static void main(String[] args) {
        (new SuperSuperTest().new Son()).thinking();
    }
}
