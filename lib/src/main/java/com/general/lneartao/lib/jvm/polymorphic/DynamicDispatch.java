package com.general.lneartao.lib.jvm.polymorphic;

import com.general.lneartao.lib.Logger;

/**
 * 方法动态分派演示，即重写
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            Logger.printl("man say hello.");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            Logger.printl("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
