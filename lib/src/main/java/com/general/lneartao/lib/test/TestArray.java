package com.general.lneartao.lib.test;

import com.general.lneartao.lib.Logger;

import java.util.List;

import static com.general.lneartao.lib.algorithm.Array.fib3;
import static com.general.lneartao.lib.algorithm.Array.findOneNumber;
import static com.general.lneartao.lib.algorithm.Array.firstMissingPositive;
import static com.general.lneartao.lib.algorithm.Array.intersection;
import static com.general.lneartao.lib.algorithm.Array.majorityElement;
import static com.general.lneartao.lib.algorithm.Array.maxProduct;
import static com.general.lneartao.lib.algorithm.Array.maxSubArray;
import static com.general.lneartao.lib.algorithm.Array.nSum;
import static com.general.lneartao.lib.algorithm.Array.oddEvenSort;
import static com.general.lneartao.lib.algorithm.Array.singleNumber;
import static com.general.lneartao.lib.algorithm.Array.threeSum;
import static com.general.lneartao.lib.algorithm.Array.twoSum;

/**
 * Created by lneartao on 2017/11/15.
 */

public class TestArray {
    public static void main(String[] args) {
//        testSingleNumber();
//        testIntersection();
//        testFindTwoSum();
//        testThreeSum();
//        testNSum();
//        testMaxSubArray();
//        testFib3();
//        testOddEvenSort();
//        testFindOneNumber();
//        testMaxProduct();
//        testmajorityElement();
        testFirstMissingPositive();
    }

    public static void testSingleNumber() {
        Logger.printl(singleNumber(new int[]{}));
        Logger.printl(singleNumber(new int[]{2}));
        Logger.printl(singleNumber(new int[]{12, 12, 2}));
        Logger.printl(singleNumber(new int[]{12, 12, 4, 2, 4}));
    }

    public static void testIntersection() {
        Logger.printl(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Logger.printl(intersection(new int[]{1, 2, 2, 1}, new int[]{}));
        Logger.printl(intersection(new int[]{}, new int[]{2}));
        Logger.printl(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2, 2, 2, 2, 2, 22}));
    }

    public static void testFindTwoSum() {
        twoSum(new int[]{1, 2, 3, 4, 7, 11, 16}, 15);
        twoSum(new int[]{1, 2, 3, 4, 7, 11, 16}, 100);
        twoSum(new int[]{1}, 1);
    }

    public static void testThreeSum() {
        for (List<Integer> list : threeSum(new int[]{-1, 0, 1, 2, -1, -4})) {
            Logger.printl(list);
        }
//        for(Lists<Integer> list:threeSum(new int[]{1,2})){
//            Logger.printl(list);
//        }
        for (List<Integer> list : threeSum(new int[]{0, 0, 0, 0})) {
            Logger.printl(list);
        }
//        for(Lists<Integer> list:threeSum(new int[]{-1,0,1,2,-1,-4})){
//            Logger.printl(list);
//        }
    }

    public static void testNSum() {
        nSum(15, 8);
    }

    public static void testMaxSubArray() {
        Logger.printl(maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
        Logger.printl(maxSubArray(new int[]{-1}));
        Logger.printl(maxSubArray(new int[2]));
    }

    private static void testFib3() {
        Logger.printl(fib3(3));
    }

    private static void testOddEvenSort() {
        int[] result = new int[]{-12, 8, -7, 0, 1, 3, 5, 6, 4};
        oddEvenSort(result);
        Logger.printl(result);
    }

    private static void testFindOneNumber() {
        Logger.printl(findOneNumber(new int[]{0, 1, 2, 1, 1,}));
        Logger.printl(findOneNumber(new int[]{1, 1, 2, 0}));
        Logger.printl(findOneNumber(new int[]{1, 2}));
    }

    private static void testMaxProduct() {
        Logger.printl(maxProduct(new double[]{-2, 3, -4}));
    }

    private static void testMajorityElement() {
        Logger.printl(majorityElement(new int[]{0, 1, 2, 1, 1,}));
        Logger.printl(majorityElement(new int[]{3, 2, 3}));
        Logger.printl(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static void testFirstMissingPositive() {
//        Logger.printl(firstMissingPositive(new int[]{1, 2, 0}));
//        Logger.printl(firstMissingPositive(new int[]{3, 4, -1, 1}));
//        Logger.printl(firstMissingPositive(new int[]{7, 8, 9, 10, 11}));
        Logger.printl(firstMissingPositive(new int[]{100000, 1000002, -1, 1}));
    }

}
