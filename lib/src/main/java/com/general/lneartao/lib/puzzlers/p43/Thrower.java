package com.general.lneartao.lib.puzzlers.p43;

/**
 * Class.newInstance方法中的设计缺陷：
 * 该方法将传播从空的构造器所抛出的任何异常，包括受检异常，使用这个方法可以有效地绕开其他情况都会执行的编译器异常检查
 * 和P43的sneakyThrow一样效果
 * 因此在使用它的时候，一定要意识到Class.newInstance可以抛出它没有声明过的受检异常
 *
 * @author lneartao
 * @date 2018/4/3.;
 */
public class Thrower {
    private static Throwable t;

    private Thrower() throws Throwable {
        throw t;
    }

    public static synchronized void sneakyThrow(Throwable t) {
        Thrower.t = t;
        try {
            Thrower.class.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } finally {
            Thrower.t = null; // Avoid memory leak
        }
    }
}
