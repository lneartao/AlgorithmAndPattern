package com.general.lneartao.lib.puzzlers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 1、不要使用'-'的比较器，问题在于定长的整数没有大到可以保存任意两个同等长度的整数之差的程度，因此可能会造成溢出
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P65 {

    public static void main(String[] args) {
        Random rnd = new Random();
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt();
        }
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
                // 替代方案一
//                return o2.compareTo(o1);
            }
        };
        Arrays.sort(arr, cmp);
        // 替代方案二，其实本质跟替代方案一是一一致的
//        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(order(arr));
    }

    enum Order {
        ASCENDING, DESCENDING, CONSTANT, UNORDERED
    }

    static Order order(Integer[] a) {
        boolean ascending = false;
        boolean descending = false;
        for (int i = 1; i < a.length; i++) {
            ascending |= a[i] > a[i - 1];
            descending |= a[i] < a[i - 1];
        }
        if (ascending && !descending) {
            return Order.ASCENDING;
        }
        if (descending && !ascending) {
            return Order.DESCENDING;
        }
        if (!ascending) {
            return Order.CONSTANT;
        }
        return Order.UNORDERED;
    }
}




