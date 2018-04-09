package com.general.lneartao.lib.puzzlers.p50;

import com.general.lneartao.lib.Logger;

/**
 * instanceof和cast的理解
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Type1 {
    public static void main(String[] args) {
        String s = null;
        Logger.printl(s instanceof String);
    }
}
