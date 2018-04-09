package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 这里有两个错误：分别是
 * 1、使用Exception来进行循环控制，修正：采用正常的循环控制方法
 * 2、&操作符和&&操作符的区别，修正：采用&&
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class P42 {
    public static void main(String[] args) {
        int[][] tests = {{6, 5, 4, 3, 2, 1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1}};
        int successCount = 0;
        try {
            int i = 0;
            while (true) {
                if (thirdElementIsThree(tests[i++])) {
                    successCount++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // No more tests to process
        }
        Logger.printl(successCount);
    }

    private static boolean thirdElementIsThree(int[] a) {
        return a.length >= 3 & a[2] == 3;
    }
}
