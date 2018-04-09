package com.general.lneartao.lib.puzzlers.rename.override;

/**
 * 一个实例方法可以覆写在其超类中可访问的具有相同签名的所有实例方法，从而实现动态分配
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class Derived extends Base {
    @Override
    public void f() {

    }
}

class Base {
    public void f() {
    }
}
