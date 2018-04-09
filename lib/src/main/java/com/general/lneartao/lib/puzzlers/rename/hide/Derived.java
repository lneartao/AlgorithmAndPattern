package com.general.lneartao.lib.puzzlers.rename.hide;

/**
 * 一个域、静态方法或成员类型可以分别隐藏在其超类中可访问到的具有相同名字的所有域、静态方法或成员类型
 * 隐藏一个成员将阻止其被继承
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class Derived extends Base {
    /*private static void f() {
    }*/

}

class Base {
    public static void f() {
    }
}
