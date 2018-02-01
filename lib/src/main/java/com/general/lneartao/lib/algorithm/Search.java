package com.general.lneartao.lib.algorithm;

/**
 * Created by lneartao on 2017/11/24.
 */

public class Search {
    /**
     * 返回某个数字在排序数组中的下标位置，-1表示不在该数组，使用二分搜索法
     *
     * @param sortedArray 排序的数组
     * @param target      目标数字
     * @return 目标数字的下标
     */
    public static int binarySearch(int[] sortedArray, int target) {
//        checkArray();
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            mid = (low + high) >>> 1;
            midVal = sortedArray[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
