package com.general.lneartao.lib.concurrency.ohter;

/**
 * Simple lock-ordering deadlock
 * 不要这么做！
 * @author lneartao
 * @date 2018/5/1.
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {

    }

    void doSomethingElse() {

    }
}
