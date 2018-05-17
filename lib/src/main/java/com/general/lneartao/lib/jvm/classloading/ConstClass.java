package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/5/16.
 */
public class ConstClass {
    static {
        Logger.printl("ConstClass Init!");
    }

    public static final String HELLO_WORLD = "hello world";
}
