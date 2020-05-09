package com.general.lneartao.lib.algorithm;

import com.general.lneartao.lib.Logger;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author lneartao
 * @date 2020/5/8.
 */
public class Queue {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            return null;
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = k - 1, maxIndex = 0, max = nums[0];
        for (int i = 1; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int j = 0;
        boolean needRefindMax = false;
        for (int i = 1; i < nums.length - k + 1; i++) {
            result[j++] = max;
            if (left == maxIndex) {
                needRefindMax = true;
            }
            left = i;
            right = left + k - 1;
            if (needRefindMax) {
                needRefindMax = false;
                for (int l = left; l <= right; l++) {
                    if (nums[l] > max) {
                        max = nums[l];
                        maxIndex = l;
                    }
                }
            } else {
                if (nums[right] > max) {
                    max = nums[right];
                    maxIndex = right;
                }
            }
        }
        result[result.length - 1] = max;
        return result;
    }

    public static void main(String[] args) {
        Logger.printl(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Logger.printl(maxSlidingWindow(new int[]{1, -1}, 1));
    }
}
