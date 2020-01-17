package com.general.lneartao.lib.effectivejava.r4.i28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 列表优于数组
 * <p>
 * 数组和泛型有两点不同：
 * 1. 数组是协变的(covariant)，如果Sub是Super的子类型，那么Sub[]就是Super[]的子类型，
 * 而泛型是可变的(invariant)，List<Sub>就不是List<Super>的子类型，比如下面的方法fun()和fun2()
 * 2. 数组是具体化的(reified)，会在运行时知道和强化它们的元素类型。泛型通过擦除，只在编译时强化它们的类型信息，并在运行时擦除元素类型信息。
 * 由于上述的原因，二者不能很好地混合使用，但是创建无限制通配类型的数组是合法的
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choiceList) {
        this.choiceList = new ArrayList<>(choiceList);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        fun();
    }

    /**
     * Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
     */
    public static void fun() {
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in.";
    }

    public static void fun2() {
        // 下面的代码在编译的时候就会出错
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("I don't fit in.");
    }
}
