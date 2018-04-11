package com.general.lneartao.lib.puzzlers;

import java.util.Random;

/**
 * 说明了算法的重要性～
 * 因此优先使用库函数，因为你可能并没有真的那么了解算法
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class P94 {
    private static Random rnd = new Random();

    private static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            swap(a, i, rnd.nextInt(a.length));
            // 修正
//            swap(a, i, i + rnd.nextInt(a.length - i));
        }
    }

    /*public static void shuffle(Object[] a) {
        Collections.shuffle(Arrays.asList(a));
    }*/

    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

//    /**
//     * 更优雅的应该是这种泛型的写法
//     *
//     * @param a
//     * @param i
//     * @param j
//     * @param <T>
//     */
//    private static <T> void swap(T[] a, int i, int j) {
//        T temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
}
