package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/5/16.
 */
public class SubClass extends SuperClass {
    static {
        Logger.printl("SubClass Init");
    }
}
