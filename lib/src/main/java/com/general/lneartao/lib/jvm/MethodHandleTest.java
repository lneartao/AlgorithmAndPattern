package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.function.IntConsumer;

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

//        testMethodHandlePerformance();
//        testMethodHandlePerformanceV2();
//        testMethodHandlePerformanceV3();
//        testMethodHandlePerformanceV4();
//        testMethodHandlePerformanceV5();
        testMethodHandlePerformanceV6();
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

    public static void target(int i) {

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

    /**
     * 测试MethodHandle的性能
     * 比反射还差 运行耗时12868
     * 它与使用 Lambda 表达式或者方法引用的差别在于，
     * 即时编译器无法将该方法句柄识别为常量，从而无法进行内联。
     * 改进方法在testMethodHandlePerformanceV4()
     *
     * @throws Throwable
     */
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

    /**
     * 测试Lambda表达式的性能
     * 好快 运行耗时2303
     */
    public static void testMethodHandlePerformanceV2() {
        long start = System.currentTimeMillis();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            ((IntConsumer) j -> MethodHandleTest.target(j)).accept(128);
            // ((IntConsumer) MethodHandleTest::target.accept(128);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 测试Lambda表达式的性能
     * 这个是带捕获变量的版本，但是由于编译器的逃逸分析把新建实例优化掉了，所以性能跟V2一样
     * 好快 运行耗时2303
     */
    public static void testMethodHandlePerformanceV3() {
        long start = System.currentTimeMillis();
        int x = 2;
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            ((IntConsumer) j -> MethodHandleTest.target(x + j)).accept(128);
            // ((IntConsumer) MethodHandleTest::target.accept(128);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    static final MethodHandle mh;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            MethodType t = MethodType.methodType(void.class, int.class);
            mh = l.findStatic(MethodHandleTest.class, "target", t);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把方法句柄赋值给final常量后，性能和V2一样了。
     *
     * @throws Throwable
     */
    public static void testMethodHandlePerformanceV4() throws Throwable {
        long start = System.currentTimeMillis();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            mh.invokeExact(128);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static class MyCallSite {

        public final MethodHandle mh;

        public MyCallSite() {
            mh = findTarget();
        }

        private static MethodHandle findTarget() {
            try {
                MethodHandles.Lookup l = MethodHandles.lookup();
                MethodType t = MethodType.methodType(void.class, int.class);
                return l.findStatic(MethodHandleTest.class, "target", t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final MyCallSite myCallSite = new MyCallSite();

    /**
     * 运行耗时7155 性能一般
     * 这个应该是每次都返回不一样的调用点，所以性能比较差
     *
     * @throws Throwable
     */
    public static void testMethodHandlePerformanceV5() throws Throwable {
        long start = System.currentTimeMillis();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            myCallSite.mh.invokeExact(128);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static class MyCallSite2 extends ConstantCallSite {

        public MyCallSite2() {
            super(findTarget());
        }

        private static MethodHandle findTarget() {
            try {
                MethodHandles.Lookup l = MethodHandles.lookup();
                MethodType t = MethodType.methodType(void.class, int.class);
                return l.findStatic(MethodHandleTest.class, "target", t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final MyCallSite2 myCallSite2 = new MyCallSite2();

    /**
     * 好快 跟V2一样
     * 这里缓存了同一个常量调用点，JVM可以直接调用调用点所链接的方法，所以性能很好
     * @throws Throwable
     */
    public static void testMethodHandlePerformanceV6() throws Throwable {
        long start = System.currentTimeMillis();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            myCallSite2.getTarget().invokeExact(128);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
