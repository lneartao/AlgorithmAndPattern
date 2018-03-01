package com.general.lneartao.lib.designpattern.flyweight;

/**
 * 享元模式
 * 似乎会有个问题：客户端可以修改享元的状态
 * Created by lneartao on 2017/11/22.
 */

public class App {
    public static void main(String[] args) {
        AlchemistShop alchemistShop = new AlchemistShop();
        alchemistShop.enumerate();
    }
}
