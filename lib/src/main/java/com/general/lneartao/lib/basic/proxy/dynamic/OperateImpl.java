package com.general.lneartao.lib.basic.proxy.dynamic;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/5/31.
 */
public class OperateImpl implements Operate {
    @Override
    public void operateMethod1() {
        Logger.printl("Invoke operateMethod1");
        sleep(110);
    }

    @Override
    public void operateMethod2() {
        Logger.printl("Invoke operateMethod2");
        sleep(120);
    }

    @Override
    public void operateMethod3(int x) {
        Logger.printl("Invoke operateMethod3");
        Logger.printl("magic num: " + x);
        sleep(130);
    }

    private static void sleep(long millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
