package com.general.lneartao.lib.puzzlers.p85;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/4/10.
 */
public class ModifiedLazy {

    private static boolean initialized = false;
    private static Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            initialized = true;
        }
    });

    static {
        t.start();
    }

    public static void main(String[] args) {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        Logger.printl(initialized);
    }
}

