package com.general.lneartao.lib.puzzlers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/4/9.
 */
public class P60 {

    /**
     * 以相同的顺序包含相同的元素，并剔除后续重复的元素，返回这个新的List
     *
     * @param original
     * @param <E>
     * @return
     */
    public static <E> List<E> withoutDuplicates(List<E> original) {
        return new ArrayList<>(new LinkedHashSet<>(original));
    }

    /**
     * 接受一个由0个或多个由逗号分隔的标志所组合的字符串，并返回一个表示这些标志的字符串数组，
     * 数组中的元素的顺序与这些标志在输入字符串中出现的顺序相同
     *
     * @param string
     * @return
     */
    public static String[] parse(String string) {
        return string.split(",\\S*");
    }

    /**
     * 它接受两个int数值，并在第一个数值与第二个数值以二进制补码形式进行比较时，具有更多的位被置位时，返回true
     * Java5后添加了一整套位操作的方法，比如,rotateLeft, reverseBytes, highestOneBit方法等等
     *
     * @param i
     * @param j
     * @return
     */
    public static boolean hasMoreBitsSet(int i, int j) {
        return Integer.bitCount(i) > Integer.bitCount(j);
    }
}
