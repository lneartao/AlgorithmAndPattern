package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 当一个变量和一个类型具有相同的名字，并且它们位于相同的作用域时，变量名具有优先权。
 * 变量名将遮掩类型名；变量名和类型名可以遮掩包名
 * 因此！ 要遵循java的命名规范
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P68 {
    public static void main(String[] args) {
        Logger.printl(X.Y.Z);
    }
}

class X {
    static class Y {
        static String Z = "Black";
    }

    static C Y = new C();
}

class C {
    String Z = "White";
}
