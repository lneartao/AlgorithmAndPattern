package com.general.lneartao.lib.effectivejava.r5.i39;

/**
 * @author lneartao
 * @date 2020/1/19.
 */
public class Sample2 {
    /**
     * Test should pass
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    /**
     * Should fail (wrong exception)
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    /**
     * Should fail (no exception)
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }
}
