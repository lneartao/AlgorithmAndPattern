package com.general.lneartao.lib.puzzlers.p85;

import com.general.lneartao.lib.Logger;

/**
 * 当一个线程访问一个类的某个成员的时候，它会去检查这个类是否已经被初始化，在忽略严重错误的情况下，有4种情况
 * 1、这个类尚未被初始化
 * 2、这个类正在被当前线程初始化，这是对初始化的递归请求
 * 3、这个类正在被其他线程而不是当前线程初始化
 * 4、这个类已经被初始化
 * <p>
 * 这里的问题在于：后台线程调用了run(), 在将Lazy.initialized设为true之前，它也会去检查Lazy类是否已经初始化；
 * 这个时候，这个类正在被另外一个线程（即主线程）进行初始化（情况3）。在这种情况下，当前线程会等待Class对象直到初始化完成
 * 遗憾的是，主线程也正在等待后台线程运行结束，那么这两个线程正在互相等待。就造成了死锁
 * <p>
 * 修正的方法
 * 1、不要在类进行初始化的时候启动任何后台线程
 * 2、让主线程在等待后台线程之前就完成类的初始化
 *
 * @author lneartao
 * @date 2018/4/10.
 * @see ModifiedLazy
 */
public class Lazy {
    private static boolean initialized = false;

    static {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        Logger.printl(initialized);
    }
}
