package com.general.lneartao.lib.concurrency.unsafe;

/**
 * Class at risk of failure if not properly published
 * 不正确的发布
 *
 * @author lneartao
 * @date 2018/4/24.
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This statement is false");
        }
    }
}
