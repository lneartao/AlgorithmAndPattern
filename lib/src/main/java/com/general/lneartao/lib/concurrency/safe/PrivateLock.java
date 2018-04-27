package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * 通过一个私有锁来保护状态
 * 使用私有锁而不用对象锁的好处：使客户端代码无法得到锁，但客户端代码可以通过公有方法来访问锁，以便参与到它的同步策略中。
 * 如果客户代码错误地获得了另一个对象的锁，那么可能会产生活跃性问题（？）
 * 此外，要想验证某个公有访问的锁在程序中是否被正确地使用，那么需要检查整个程序，而不是单个类
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class PrivateLock {
    private final Object myLock = new Object();

    @GuardedBy("myLock")
    Widget mWidget;

    void doSomeWork() {
        synchronized (myLock) {
            // 访问或修改mWidget的状态
        }
    }

    class Widget {

    }
}
