package com.general.lneartao.lib.jvm.polymorphic;

import com.general.lneartao.lib.Logger;

import java.io.Serializable;

/**
 * 重载
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class Overload {
    public static void sayHello(Object org) {
        Logger.printl("hello Object");
    }

    public static void sayHello(int org) {
        Logger.printl("hello int");
    }

    public static void sayHello(long org) {
        Logger.printl("hello long");
    }

    public static void sayHello(Character org) {
        Logger.printl("hello Character");
    }

    public static void sayHello(char org) {
        Logger.printl("hello char");
    }

    public static void sayHello(char... org) {
        Logger.printl("hello char...");
    }

    public static void sayHello(Serializable org) {
        Logger.printl("hello Serializable");
    }

    public static void main(String[] args) {
        Overload.sayHello("c");
    }
}
