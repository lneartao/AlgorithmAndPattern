package com.general.lneartao.lib.puzzlers.p95;

import com.general.lneartao.lib.Logger;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 这个从输出结果来看是正确的啊，书里说输出结果应该是未排序的状态
 * 有点迷惑～
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class BananaBread {

    public static void main(String[] args) {
        Integer[] array = {3, 1, 4, 1, 5, 9};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o2 > o1 ? 1 : 0);
            }
        });
        Logger.printl(Arrays.toString(array));
    }
}
