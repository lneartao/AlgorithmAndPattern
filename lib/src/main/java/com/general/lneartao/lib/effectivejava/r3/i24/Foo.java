package com.general.lneartao.lib.effectivejava.r3.i24;

/**
 * @author lneartao
 * @date 2020/1/16.
 */
public class Foo {

    private boolean isTrue;

    private boolean isTrue() {
        return isTrue;
    }

    public static class FooInner {
        private int count;

        private void test(Foo foo) {
            boolean innerTure = foo.isTrue;
            innerTure = foo.isTrue();
        }
    }

    private class FooInner2 {
        private boolean isFalse = !isTrue;

        private void test() {
            boolean innerFalse = !isTrue();
        }
    }
}
