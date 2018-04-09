package com.general.lneartao.lib.puzzlers.p44;

import com.general.lneartao.lib.Logger;

/**
 * 如果删除Missing类，该类会抛出未被捕获的NoClassDefFoundError异常
 * 要想了解Strange1和Strange2的区别，必须得看字节码才行～
 * javap -c Strange1
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Strange1 {
    public static void main(String[] args) {
        try {
            Missing m = new Missing();
        } catch (NoClassDefFoundError error) {
            Logger.printl("Got it!");
        }
    }
}
