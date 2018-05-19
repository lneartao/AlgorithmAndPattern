package com.general.lneartao.lib.jvm.polymorphic;

import com.general.lneartao.lib.Logger;

/**
 * 方法静态分派演示，即重载
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        Logger.printl("hello guy.");
    }

    public void sayHello(Man man) {
        Logger.printl("hello man.");
    }

    public void sayHello(Woman woman) {
        Logger.printl("hello woman.");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
