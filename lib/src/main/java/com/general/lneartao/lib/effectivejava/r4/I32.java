package com.general.lneartao.lib.effectivejava.r4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 谨慎并用泛型和可变参数
 * <p>
 * 可变参数是个技术露底，当调用一个可变参数方法时，会创建一个数组用来存放可变参数，这个数组是一个实现细节，它是可见的。
 * 当一个参数化类型的变量指向一个不是该类型的对象时，会产生堆污染，导致自动转换失败，破坏了泛型系统的基本保证。
 * SafeVarargs注解是通过方法的设计者做出承诺，声明这是类型安全的。
 * 允许另一个方法访问一个泛型可变参数数组是不安全的。、对于每一个带有泛型可变参数或参数化类型的方法，都要用@SafeVarargs进行注解
 * 泛型可变参数方法在下列条件下是安全的：
 * 1. 它没有在可变参数数组中保存任何值
 * 2. 它没有对不被信任的代码开放该数组，下面的toArray方法就开放了数组
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class I32 {

    public static void main(String[] args) {
        dangerous(new ArrayList<>());
    }

    /**
     * 将值保存在泛型可变参数数组参数中是不安全的
     * 下面的这些方法是正确的使用姿势
     * {@link java.util.Arrays#asList(Object[])}
     * {@link java.util.Collections#addAll(Collection, Object[])}
     *
     * @param lists
     */
    static void dangerous(List<String>... lists) {
        List<Integer> intList = new ArrayList<>();
        intList.add(42);
        Object[] objects = lists;
        objects[0] = intList;
        String s = lists[0].get(0); // ClassCastException
    }

    static <T> T[] toArray(T... args) {
        return args;
    }
}
