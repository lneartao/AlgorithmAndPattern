package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 提醒：
 * 1、一个覆写方法的访问修饰符所提供的访问权限与被覆写方法的访问修饰符所提供的访问权限相比，至少要一样多
 * 2、对一个域（属性）而言，当它要隐藏另一个域时，如果隐藏域的访问修饰符提供的访问权限比被隐藏域的少，尽管这么做不可取，但它确实是合法的。
 * 事实上，对于隐藏域而言，如果它具有与被隐藏域完全无关的类型，也是合法的。
 * 3、覆写和隐藏之间的一个非常大的区别：方法在子类中被覆写，那么在之类的实例中就不能调用它了
 * 然而，你可以通过将子类实例转型为某个超类来访问被隐藏的域，在这个超类中该域未被隐藏
 * 4、隐藏有可能会违反包容性原则即Liskov置换原则，应该尽量避免使用隐藏
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P66 {

    public static void main(String[] args) {
        // className被Derived类隐藏了，所以无法访问
//        Logger.printl(new Derived().className);
        Logger.printl(((Base) new Derived()).className);
    }
}

class Base {
    public String className = "Base";
}

class Derived extends Base {
    private String className = "Derived";
}

