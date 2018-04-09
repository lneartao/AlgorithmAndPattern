package com.general.lneartao.lib.puzzlers.p44;

import com.general.lneartao.lib.Logger;

/**
 * 如果删除Missing类，该类会抛出未被捕获的NoClassDefFoundError异常
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Strange2 {
    public static void main(String[] args) {
        Missing m;
        try {
            m = new Missing();
        } catch (NoClassDefFoundError error) {
            Logger.printl("Got it!");
        }
    }
}
