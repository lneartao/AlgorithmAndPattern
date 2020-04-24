package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * jdk7的MethodHandle演示
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            Logger.printl(s);
        }
    }

    public static void main(String[] args) throws Throwable {
//        Object object = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        // 无论object最终是哪个实现类，下面这句都能正确调用到println方法
//        getPrintlnMH(object).invokeExact("icyfenix");

        testMethodHandlePerformance();
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        // 代表方法类型，包含了方法的返回值（第一个参数），及具体参数（第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class, String.class);
        // lookup的作用是在指定类中查找符合给定方法名称、方法类型、并且符合调用权限的方法句柄
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是this指向的对象，
        // 这个参数以前是放在参数列表中进行传递的的，而现在提供了bindTo()方法来完成这件事情
        return MethodHandles.lookup()
                            .findVirtual(receiver.getClass(), "println", mt)
                            .bindTo(receiver);
    }

    private void bar(Object o) {
//        Logger.printl(o);
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

    private static MethodHandle findMethodHandleOne()
            throws NoSuchMethodException, IllegalAccessException {
        // 具备 Foo 类的访问权限
        MethodHandles.Lookup l = MethodHandleTest.lookup();
        Method m = MethodHandleTest.class.getDeclaredMethod("bar", Object.class);
        return l.unreflect(m);
    }

    /**
     * 根据类、方法名以及方法句柄类型来查找。
     * 当使用后者这种查找方式时，用户需要区分具体的调用类型
     * 比如说对于用 invokestatic 调用的静态方法，我们需要使用 Lookup.findStatic 方法
     *
     * @return
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    private static MethodHandle findMethodHandleTwo()
            throws NoSuchMethodException, IllegalAccessException {
        // 具备 Foo 类的访问权限
        MethodHandles.Lookup l = MethodHandleTest.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        return l.findVirtual(MethodHandleTest.class, "bar", t);
    }

    public void test(MethodHandle mh, String s) throws Throwable {
        mh.invokeExact(s);
        mh.invokeExact((Object) s);
    }

    // 这个性能比反射还差啊
    public static void testMethodHandlePerformance()
            throws Throwable {
        long start = System.currentTimeMillis();
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = l.findVirtual(MethodHandleTest.class, "bar", t);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            mh.invokeExact(new MethodHandleTest(), new Object());
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
