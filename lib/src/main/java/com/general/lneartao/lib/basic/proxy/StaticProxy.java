package com.general.lneartao.lib.basic.proxy;

/**
 * 代理类
 * 代理类在程序运行前已经存在的代理方式称为静态代理
 *
 * @author lneartao
 * @date 2018/5/31.
 */
public class StaticProxy {
    private InternalClass a;

    public StaticProxy(InternalClass a) {
        this.a = a;
    }

    public void operateMethod1() {
        a.operateMethod1();
    }

    public void operateMethod2() {
        a.operateMethod2();
    }

    // not export operateMethod3()
}

/**
 * 委托类
 */
class InternalClass {
    public void operateMethod1() {
    }

    public void operateMethod2() {
    }

    public void operateMethod3() {
    }
}
