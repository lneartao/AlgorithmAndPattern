package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/5/16.
 */
public class SuperClass {

    static {
        Logger.printl("SuperClass init");
    }

    public static int value = 123;
}
