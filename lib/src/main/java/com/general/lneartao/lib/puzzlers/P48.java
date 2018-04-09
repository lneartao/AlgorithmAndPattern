package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 静态方法调用和多态的相似性问题
 * 当一个程序调用了一个静态方法时，要被调用的方法都是在编译时刻被选定的，而这种选定是基于修饰符的编译期类型而做出的，即Dog
 * 因此这不是多态。正确的调用方式也应该用类名Dog.bark()，而不是实例名+方法的形式假装自己是多态
 * 这里只要bark方法去掉static就是多态了，就能得到我们理想中的答案
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class P48 {
    public static void main(String[] args) {
        Dog woofer = new Dog();
        Dog nipper = new Basenji();
        woofer.bark();
        nipper.bark();
    }
}

class Dog {
    public static void bark() {
        Logger.printl("woof");
    }
}

class Basenji extends Dog {
    public static void bark() {
    }
}
