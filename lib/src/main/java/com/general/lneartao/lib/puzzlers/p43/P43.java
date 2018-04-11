package com.general.lneartao.lib.puzzlers.p43;

/**
 * @author lneartao
 * @date 2018/4/3.
 */
public class P43 {

    /**
     * 这个例子说明的是：它可以绕过编译器的所有异常检查操作，你可以在你的代码的任意一点上抛出任何受检异常或不受检异常，而编译器对此毫无反应
     * 不要这么做
     *
     * @param t
     */
    public static void sneakyThrow(Throwable t) {
        Thread.currentThread().stop(t);
    }

    public static void main(String[] args) {
        sneakyThrow(new Throwable());
    }
}
