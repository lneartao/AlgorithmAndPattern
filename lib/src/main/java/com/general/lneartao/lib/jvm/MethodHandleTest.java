package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

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
        Object object = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        // 无论object最终是哪个实现类，下面这句都能正确调用到println方法
        getPrintlnMH(object).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        // 代表方法类型，包含了方法的返回值（第一个参数），及具体参数（第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class, String.class);
        // lookup的作用是在指定类中查找符合给定方法名称、方法类型、并且符合调用权限的方法句柄
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是this指向的对象，
        // 这个参数以前是放在参数列表中进行传递的的，而现在提供了bindTo()方法来完成这件事情
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
