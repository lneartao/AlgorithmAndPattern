package com.general.lneartao.lib.effectivejava.r4;

import java.util.List;

/**
 * 利用有限制通配符来提升API的灵活性
 * <p>
 * 为了获得最大限度的灵活性，要在表示生产者或消费者的输入参数上使用通配符类型，
 * PECS 表示 producer-extends, consumer-super, <? super T> <? extends T>
 * 不要用通配符类型作为返回类型，应该只返回 E
 * 如果类型参数只在方法声明中出现一次，就可以用通配符取代它
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class I31 {

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
        // 无法这么使用
//        list.set(i, list.set(j, list.get(i)));
    }

    /**
     * 编写一个私有的辅助方法来捕捉通配符类型
     *
     * @param list
     * @param i
     * @param j
     * @param <E>
     */
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
