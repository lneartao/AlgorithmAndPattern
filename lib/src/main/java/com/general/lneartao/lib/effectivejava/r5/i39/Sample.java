package com.general.lneartao.lib.effectivejava.r5.i39;

/**
 * @author lneartao
 * @date 2020/1/19.
 */
public class Sample {
    /**
     * Test should pass
     */
    @Test
    public static void m1() {

    }

    public static void m2() {

    }

    /**
     * Test show fail
     */
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {

    }

    /**
     * INVALID USE: nonstatic method
     */
    @Test
    public void m5() {

    }

    public static void m6() {

    }

    /**
     * Test should fail
     */
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {

    }
}
