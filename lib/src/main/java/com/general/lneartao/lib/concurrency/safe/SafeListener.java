package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

/**
 * 如果想在构造函数中注册一个事件监听器或启动线程，那么可以使用一个私有的构造器和一个公共的工厂方法，从而避免不正确的构造过程
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener getInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {

    }

    interface EventSource {
        void registerListener(EventListener listener);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {

    }
}
