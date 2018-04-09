package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 要么用某种类型来限定静态方法调用，要么就压根不限定它们
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P54 {
    public static void greet() {
        Logger.printl("Hello world!");
    }

    public static void main(String[] args) {
        ((P54) null).greet();
        greet();
    }
}
