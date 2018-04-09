package com.general.lneartao.lib.puzzlers;

import java.lang.reflect.Constructor;

/**
 * 1、Class.newInstance()的描述：如果那个Class对象代表了一个抽象类、一个接口、一个数组类(array class)、一个原始类型或是空
 * 或者这个类没有任何空的构造器，或者实例化由于某些其他原因而失败，那么它就会抛出异常
 * 2、一个非静态的嵌套类的构造器，在编译的时候会将一个隐藏的参数作为它的第一个参数，这个参数表示了它的直接外围实例。
 * 当使用反射的时候，这个隐藏的参数就需要被显式地传递，而传递该参数的唯一方法是使用Constructor，如下的正确版
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P80 {

    public static void main(String[] args) throws Exception {
        new P80().greetWorld();
    }

    private void greetWorld() throws Exception {
//        wrongMethod();
        correctMethod();
    }

    private void correctMethod() throws Exception {
        Constructor<Inner> c = Inner.class.getConstructor(P80.class);
        System.out.println(c.newInstance(P80.this));
    }

    private void wrongMethod() throws InstantiationException, IllegalAccessException {
        System.out.println(Inner.class.newInstance());
    }

    public class Inner {
        @Override
        public String toString() {
            return "Hello world";
        }
    }
}
