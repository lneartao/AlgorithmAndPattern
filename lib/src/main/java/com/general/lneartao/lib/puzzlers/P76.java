package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 1、在一个同步化的静态方法执行之前，它会获取与它的Class对象相关联的一个管程锁(monitor)
 * 2、由于一个线程可以重复地获取某个相同的锁
 * 3、下面的例子中start()和rn()的结果不一样！
 * 4、start()是启动线程，而run()并没有启动线程，run()会在主线程中同步地运行
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P76 {

    public static synchronized void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
//        t.start();
        t.run();
        Logger.printl("Ping");
    }

    static synchronized void pong() {
        Logger.printl("Pong");
    }
}
