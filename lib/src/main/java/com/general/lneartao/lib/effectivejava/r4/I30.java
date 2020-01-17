package com.general.lneartao.lib.effectivejava.r4;

import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * 优先考虑泛型方法
 * <p>
 * 静态工具方法尤其适合于泛型化，比如 {@link java.util.Collections#binarySearch(List, Object)} 等等
 * 泛型单例工厂，创建一个不可变但又适用于许多不同类型的对象 {@link java.util.Collections#reverse(List)} {@link Collections#emptyList()}
 * 恒等函数分发器，如下的例子
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class I30 {

    private static UnaryOperator<Object> IDENTIFY_EN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTIFY_EN;
    }
}
