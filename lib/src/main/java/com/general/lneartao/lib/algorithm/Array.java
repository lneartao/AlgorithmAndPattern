package com.general.lneartao.lib.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lneartao
 */
public class Array {

    /**
     * 返回数组中唯一的数字
     *
     * @param nums 数组
     * @return 唯一的数字
     */
    public static int singleNumber(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        int result = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static int singleNumberUgly(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer result : map.keySet()) {
            return result;
        }
        return -1;
    }

    /**
     * 返回两个数组的并集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 并集数组
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums1) {
            map.put(num, 1);
        }
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int start = 0;
        for (Integer num : nums2) {
            if (map.getOrDefault(num, 0) == 1) {
                temp[start++] = num;
                map.replace(num, 2);
            }
        }
        int[] result = new int[start];
        for (int i = 0; i < start; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /**
     * 寻找和为定值的两个数,利用hashmap的特性实现O(N)的解法
     *
     * @param arr 数组
     * @param sum 定值
     */
    public static void twoSum(int[] arr, int sum) {
        if (arr == null || arr.length < 2) {
            return;
        }
        HashMap<Integer, Boolean> hashMap = new HashMap<>(arr.length);
        for (Integer integer : arr) {
            hashMap.put(integer, true);
        }
        for (Integer integer : arr) {
            if (hashMap.getOrDefault(sum - integer, false)) {
                System.out.println(integer + " + " + (sum - integer) + " = " + sum);
                return;
            }
        }
        System.out.println("Not found!");
    }

    /**
     * 三数之和为0的唯一所有序列
     * https://leetcode.com/problems/3sum/description/
     *
     * @param nums 数组
     * @return 所有合理序列
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> item;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            // 下面这部分是2sum的大概解法
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    item = new ArrayList<>(3);
                    item.add(-target);
                    item.add(nums[left++]);
                    item.add(nums[right--]);
                    result.add(item);
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 在1..n中寻找和为定值的多个数，其实算是01背包问题
     *
     * @param sum 定值
     * @param n
     */
    public static void nSum(int sum, int n) {
        List<Integer> list = new LinkedList<>();
        sumOfNumber(list, sum, n);
    }

    private static void sumOfNumber(List<Integer> list, int sum, int n) {
        if (n <= 0 || sum <= 0) {
            return;
        }
        if (sum == n) {
            for (Integer integer : list) {
                System.out.print(integer + " + ");
            }
            System.out.println(n);
        }
        list.add(list.size(), n);
        sumOfNumber(list, sum - n, n - 1);
        list.remove(list.size() - 1);
        sumOfNumber(list, sum, n - 1);
    }

    /**
     * 最大连续子序列，时间复杂度O(N)，空间复杂度O(1)
     * 即便要输出找到的最大连续子序列也不难，用start和end保存下标即可
     * https://leetcode.com/problems/maximum-subarray/description/
     *
     * @param arr
     * @return
     */
    public static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int curSum = 0;
        int maxSum = arr[0];
        for (Integer value : arr) {
            curSum = Math.max(value, value + curSum);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 斐波那契数列问题
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 一个台阶总共有n 级，如果一次可以跳1、2、3级，求总共有多少总跳法
     *
     * @param n 台阶
     * @return 跳法
     */
    public static int fib3(int n) {
        int[] result = new int[]{0, 1, 2, 4};
        if (n < 4) {
            return result[n];
        }
        return fib3(n - 1) + fib3(n - 2) + fib3(n - 3);
    }

    /**
     * 跳房子问题，实质是斐波那契数列问题
     * 一个台阶总共有n 级，如果一次可以跳1级，也可以跳2级，求总共有多少总跳法，并分析算法的时间复杂度。
     *
     * @param n 台阶
     * @return 跳法
     */
    public static int climbStairs(int n) {
        if (n < -1) {
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }

    /**
     * 奇偶排序问题 O(N)
     *
     * @param arr 数组
     */
    public static void oddEvenSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (isOddNumber(arr[start])) {
                start++;
            } else if (!isOddNumber(arr[end])) {
                end--;
            } else {
                swap(arr, start, end);
            }
        }
    }

    private static boolean isOddNumber(int value) {
        return (value & 1) == 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 现有N个红白蓝三种不同颜色的小球，乱序排列在一起，通过两两交换任意两个球，使得从左至右，依次是一些红球、白球和蓝球
     * 比如0代表红球，1代表白球，2代表蓝球
     * https://leetcode.com/problems/sort-colors/description/
     * 算法：
     * current指针所指元素为0时，与start指针所指的元素交换，而后current++,begin++
     * current指针所指元素为1时，不做任何交换，current++
     * current指针所指元素为2时，与end指针所指元素交换，而后end--，current不变
     *
     * @param nums 数组
     */
    public static void sortDutchFlag(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int red = 0, current = 0, blue = nums.length - 1;
        while (current <= blue) {
            if (nums[current] == 0) {
                swap(nums, red++, current++);
            } else if (nums[current] == 2) {
                swap(nums, current, blue--);
            } else {
                current++;
            }
        }
    }

    /**
     * 问题：有个长度为2n的数组{a1,a2,a3,...,an,b1,b2,b3,...,bn}，希望排序后{a1,b1,a2,b2,...,an,bn}
     * 解法：完美洗牌算法1--位置置换 时间复杂度和空间复杂度都是O(N)
     * 设定数组的下标从1开始，下标范围是[1..2n]，所以数组是这样的{0,a1,a2,...,an,b1,b2,...,bn}，arr的长度是n+1，真实长度是n
     *
     * @param arr 数组
     * @param n   数组的真实长度
     */
    public static void perfectShuffle1(int[] arr, int n) {
        int i;
        int[] arr2 = new int[arr.length];
        for (i = 1; i <= n; i++) {
            arr2[(i * 2) % (n + 1)] = arr[i];
        }
        for (i = 1; i <= n; i++) {
            arr[i] = arr2[i];
        }
    }

    /**
     * 在杨氏矩阵中查找某个数是否存在
     * 这里使用Step-wise线性搜索算法，比较容易理解，时间复杂度是O(row+col)
     *
     * @param arr       非空二维杨氏矩阵
     * @param searchVal 要查找的值
     * @return 是否存在
     */
    public static boolean youngMatrix(int[][] arr, int searchVal) {
        int arrRow = arr.length;
        int arrCol = arr[0].length;
        if (searchVal < arr[0][0] || searchVal > arr[arrRow - 1][arrCol - 1]) {
            return false;
        }
        int row = 0;
        int col = arrCol - 1;
        while (row < arrRow && col >= 0) {
            if (arr[row][col] < searchVal) {
                row++;
            } else if (arr[row][col] > searchVal) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 在数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字
     * 其实排除了一种特殊情况，例如{1,1,2,0}, {1,2}
     * 解法一：排序后直接返回n/2位置的数字，时间复杂度为O(nlongn）
     * 解法二：使用hashmap，时间复杂度为O(2N)
     * 下面是解法三
     *
     * @param arr
     * @return
     */
    public static int findOneNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int candidate = arr[0];
        int nTimes = 1;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes++;
            } else {
                if (candidate == arr[i]) {
                    nTimes++;
                } else {
                    nTimes--;
                }
            }
        }
        return candidate;
    }

    /**
     * 最大连续乘积子串，O(N)的时间复杂度
     * https://leetcode.com/problems/maximum-product-subarray/description/
     *
     * @param arr
     * @return
     */
    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        double maxEnd = arr[0];
        double minEnd = arr[0];
        double maxResult = arr[0];
        double end1, end2;
        for (int i = 1; i < len; i++) {
            end1 = maxEnd * arr[i];
            end2 = minEnd * arr[i];
            maxEnd = Math.max(Math.max(end1, end2), arr[i]);
            minEnd = Math.min(Math.min(end1, end2), arr[i]);
            maxResult = Math.max(maxEnd, maxResult);
        }
        return maxResult;
    }

    /**
     * 递增三元子序列
     * https://leetcode.com/problems/increasing-triplet-subsequence/description/
     *
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MAX_VALUE;
        for (Integer x : nums) {
            if (x <= x1) {
                x1 = x;
            } else if (x <= x2) {
                x2 = x;
            } else {
                return true;
            }
        }
        return false;
    }

}
