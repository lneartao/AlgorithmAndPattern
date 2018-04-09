package com.general.lneartao.lib.puzzlers.rename.overload;

/**
 * 在某个类中的方法可以重载另一个方法，只要它们具有相同的名字和不同的签名
 * 由调用所指定的重载方法是在编译期选定的
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class CircuitBreaker {
    public void f(int i) {
    }

    public void f(String s) {
    }
}
