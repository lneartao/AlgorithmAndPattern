package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * Math.abs()方法的bug，在值为Integer.MIN_VALUE或Long.MIN_VALUE时，abs方法返回的仍然是MIN_VALUE值，因此造成了下面代码的数组越界错误
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P64 {

    public static void main(String[] args) {
        final int MODULUS = 3;
        int[] histogram = new int[MODULUS];
        int i = Integer.MIN_VALUE;
        do {
//            histogram[Math.abs(i) % MODULUS]++;
            // 订正版本
            histogram[mod(i, MODULUS)]++;
        } while (i++ != Integer.MAX_VALUE);
        for (int j = 0; j < MODULUS; j++) {
            Logger.printl(histogram[j] + " ");
        }
    }

    private static int mod(int i, int modulus) {
        int result = i % modulus;
        return result < 0 ? result + modulus : result;
    }
}
