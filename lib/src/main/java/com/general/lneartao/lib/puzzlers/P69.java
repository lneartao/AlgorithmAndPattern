package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 巧妙地读取X.Y类中Z域的值
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P69 {

    public static void main(String[] args) {
        methodOne();
        methodTwo();
        methodThree();
    }

    private static void methodOne() {
        Logger.printl(((X.Y) null).Z);
    }

    static class Xy extends X.Y {
    }

    private static void methodTwo() {
        Logger.printl(Xy.Z);
    }

    private static <T extends X.Y> void methodThree() {
        Logger.printl(T.Z);
    }

}
