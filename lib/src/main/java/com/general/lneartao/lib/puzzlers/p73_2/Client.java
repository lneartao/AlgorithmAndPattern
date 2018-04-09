package com.general.lneartao.lib.puzzlers.p73_2;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.puzzlers.p73_1.Api;

/**
 * 写一个final的库类和客户类，这两者都可以毫无问题地通过编译，然后在库类中添加一个私有成员，
 * 使得库类仍然能够编译，而客户类却再也不能编译！
 * 重用名字是危险的！
 * （突然想到一种很可怕的事情，引用第三方库开发的时候，如果第三方库被故意的造成这种类型的问题，那么引用该库的应用都会有问题啊！）
 * 有两个方法
 * 方法一：遮蔽类型
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class Client {
    String s = Api.newString();

    public static void main(String[] args) {
        Logger.printl("Hello");
    }
}
