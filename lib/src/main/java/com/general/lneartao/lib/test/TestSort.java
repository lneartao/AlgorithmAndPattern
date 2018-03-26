package com.general.lneartao.lib.test;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.algorithm.Sort;

/**
 * @author lneartao
 * @date 2018/3/2.
 */

public class TestSort {
    public static void main(String[] args) {
//        testFindPeakElement();
        Logger.printl(computeCount(-4));
        Logger.printl(computeCount(0));
        Logger.printl(computeCount(3));
        Logger.printl(computeCount(4));
        Logger.printl(computeCount(5));
//        Logger.printl(computeCount(7));
        Logger.printl(computeCount(8));
        Logger.printl(computeCount(10));
        Logger.printl(computeCount(12));
//        Logger.printl(computeCount(13));
        Logger.printl(computeCount(15));
    }

    private static void testFindPeakElement() {
        Logger.printl(Sort.findPeakElement(new int[]{1}));
        Logger.printl(Sort.findPeakElement(new int[]{1, 2}));
        Logger.printl(Sort.findPeakElement(new int[]{2, 1,}));
        Logger.printl(Sort.findPeakElement(new int[]{1, 2, 3, 1}));
    }

    private static int computeCount(int size) {
        int temp = (int) Math.ceil(size % 5);
        Logger.printl("temp: " + temp);
        return temp > 0 ? size / temp : size;
    }
}
