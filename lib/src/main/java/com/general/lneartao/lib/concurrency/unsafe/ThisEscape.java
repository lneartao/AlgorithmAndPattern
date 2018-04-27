package com.general.lneartao.lib.concurrency.unsafe;

/**
 * 当ThisEscape发布EventListener时，也隐含地发布了ThisEscape实例本身，
 * 因为在这个内部类的实例中包含了对ThisEscape实例的隐含引用
 * 这里是在构造过程中使this引用逸出了
 * 不要在构造器中创建线程
 * <p>
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/24.
 * @see com.general.lneartao.lib.concurrency.safe.SafeListener
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {

    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {

    }
}
