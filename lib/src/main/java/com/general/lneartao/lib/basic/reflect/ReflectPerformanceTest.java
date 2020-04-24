package com.general.lneartao.lib.basic.reflect;

import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2020/4/23.
 */
public class ReflectPerformanceTest {

    public static void main(String[] args) throws Exception {
//        showProxyInvokeStack();
//        showDynamicInvokeStack();
        // 性能越来越好
//        testV1();
//        testV2();
//        testV3();
//        testV4();
//        testV5();
    }

    private static void showProxyInvokeStack() throws Exception {
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("targetException", int.class);
        method.invoke(null, 0);
    }

    private static void showDynamicInvokeStack() throws Exception {
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("targetException", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }

    public static void targetException(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void target(int i) {
        // 空方法
    }

    private static void testV1() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("target", int.class);
        polluteProfile();

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
        System.out.println("end: " + (System.currentTimeMillis() - start));
    }

    public static void polluteProfile() throws Exception {
        Method method1 = ReflectPerformanceTest.class.getMethod("target", int.class);
        Method method2 = ReflectPerformanceTest.class.getMethod("target", int.class);
        for (int i = 0; i < 2000; i++) {
            method1.invoke(null, 0);
            method2.invoke(null, 0);
        }
    }

    public static void target1(int i) {
    }

    public static void target2(int i) {
    }

    private static void testV2() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("target", int.class);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
        System.out.println("end: " + (System.currentTimeMillis() - start));
    }

    /**
     * Integer缓存是-128 127，这里去掉了装箱拆箱的性能消耗
     *
     * @throws Exception
     */
    private static void testV3() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("target", int.class);

        Object[] arg = new Object[1]; // 在循环外构造参数数组
        arg[0] = 128;

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, arg);
        }
        System.out.println("end: " + (System.currentTimeMillis() - start));
    }

    /**
     * 关闭权限检查
     *
     * @throws Exception
     */
    private static void testV4() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);  // 关闭权限检查

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
        System.out.println("end: " + (System.currentTimeMillis() - start));
    }

    private static void testV5() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> klass = ReflectPerformanceTest.class;
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);  // 关闭权限检查
        Object[] arg = new Object[1]; // 在循环外构造参数数组
        arg[0] = 128;
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, arg);
        }
        System.out.println("end: " + (System.currentTimeMillis() - start));
    }

}


