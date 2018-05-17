package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

/**
 * 一次对象自我拯救的演示
 * 1、对象可以在被GC时自我拯救
 * 2、这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * 尽量避免使用这种方式来自救
 *
 * @author lneartao
 * @date 2018/5/15.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        Logger.printl("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Logger.printl("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            Logger.printl("no, i am dead :(");
        }

        // 这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            Logger.printl("no, i am dead :(");
        }

    }
}
