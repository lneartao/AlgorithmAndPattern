package com.general.lneartao.lib.practice.search;

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
            // 防止溢出
            mid = low + ((high - low) >> 1);
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

    /**
     * 二分查找的递归实现
     *
     * @param a
     * @param n
     * @param val
     * @return
     */
    public static int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    public static int binarySearchFirst(int[] sortedArray, int target) {
//        checkArray();
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            // 防止溢出
            mid = low + ((high - low) >> 1);
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

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param sortedArray
     * @param value
     * @return
     */
    public int bsearchVar1(int[] sortedArray, int value) {
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            // 防止溢出
            mid = low + ((high - low) >> 1);
            midVal = sortedArray[mid];
            if (midVal == value) {
                // 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                // 如果 mid 不等于 0，但 a[mid] 的前一个元素 a[mid-1] 不等于 value，
                // 那也说明 a[mid] 就是我们要找的第一个值等于给定值的元素。
                if ((mid == 0) || sortedArray[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            } else if (midVal < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     *
     * @param sortedArray
     * @param value
     * @return
     */
    public int bsearchVar2(int[] sortedArray, int value) {
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            midVal = sortedArray[mid];
            if (midVal == value) {
                // 如果 a[mid] 这个元素已经是数组中的最后一个元素了，那它肯定是我们要找的；
                // 如果 a[mid] 的后一个元素 a[mid+1] 不等于 value，
                // 那也说明 a[mid] 就是我们要找的最后一个值等于给定值的元素。
                if ((mid == sortedArray.length - 1) || sortedArray[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            } else if (midVal < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     *
     * @param sortedArray
     * @param value
     * @return
     */
    public int bsearchVar3(int[] sortedArray, int value) {
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            midVal = sortedArray[mid];
            if (midVal >= value) {
                // 先看下这个 a[mid] 是不是我们要找的第一个值大于等于给定值的元素。
                // 如果 a[mid] 前面已经没有元素，或者前面一个元素小于要查找的值 value，
                // 那 a[mid] 就是我们要找的元素。
                if ((mid == 0) || (sortedArray[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1);
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     *
     * @param sortedArray
     * @param value
     * @return
     */
    public int bsearchVar4(int[] sortedArray, int value) {
        int low = 0, high = sortedArray.length - 1, mid, midVal;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            midVal = sortedArray[mid];
            if (midVal <= value) {
                if ((mid == sortedArray.length - 1) || sortedArray[mid + 1] > value) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
