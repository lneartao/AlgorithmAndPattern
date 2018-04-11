package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 该程序包含了一个无限递归
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P40 {
    // 这句是造成无限递归的代码～
    private P40 internalInstance = new P40();

    public P40() throws Exception {
        throw new Exception("I'm not coming out");
    }

    public static void main(String[] args) {
        try {
            P40 b = new P40();
            Logger.printl("Surprise!");
        } catch (Exception ex) {
            Logger.printl("I told you so");
        }
    }
}
