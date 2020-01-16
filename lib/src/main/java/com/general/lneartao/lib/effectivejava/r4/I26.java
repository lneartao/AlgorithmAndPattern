package com.general.lneartao.lib.effectivejava.r4;

import java.util.ArrayList;
import java.util.List;

/**
 * 请不要使用原生态类型
 * <p>
 * 术语：
 * 参数化的类型 List<String>
 * 实际类型参数 String
 * 泛型 List<E>
 * 形式类型参数 E
 * 无限制通配符类型 List<?>
 * 原生态类型 List
 * 有限制类型参数 <E extends Number>
 * 递归类型限制 <T extends Comparable<T>>
 * 有限制通配符类型 List<? extends Number>
 * 泛型方法 static<E> List<E> asList(E[] a)
 * 类型令牌 String.class
 *
 * <p>
 * 如果使用原生态类型，就失掉了泛型在安全性（在编译时就出错，而不是在运行时才出错）和描述性方面的所有优势
 * 如果使用像List这样的原生态类型，就是失掉类型安全性，但是如果使用像List<Object>这样的参数化类型，就不会。如下面的例子。
 * <p>
 * 不要使用原生态类型的例外：
 * 1. 必须在 class literal 中使用原生态类型， List.class, String[].class
 * 2. instanceof操作符会擦除类型
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public class I26 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(42));
//        safeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    /**
     * 这个增加了类型检测，所以在编译的时候就无法通过，增加了安全性
     *
     * @param list
     * @param o
     */
    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }
}
