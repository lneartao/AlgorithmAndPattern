package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 为Enigma提供一个声明，使得该程序打印false
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P74 {
    public static void main(String[] args) {
        Enigma e = new Enigma();
        Logger.printl(e.equals(e));
    }
}

/**
 * 方法二，在构造器中动手脚～
 */
final class Enigma {
    public Enigma() {
        Logger.printl(false);
        System.exit(0);
    }
}

/**
 * 方法二，最好不要这么做
 * 使用重载很容易引起混乱
 */
final class Enigma2 {
    public boolean equals(Enigma2 ohter) {
        return false;
    }
}
