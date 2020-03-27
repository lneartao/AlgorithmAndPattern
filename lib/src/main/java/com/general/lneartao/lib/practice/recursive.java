package com.general.lneartao.lib.practice;

/**
 * @author lneartao
 * @date 2020/3/27.
 */
public class recursive {
    public static void main(String[] args) {
        System.out.println(countCount(4));
    }

    /**
     * 1 个细胞的生命周期是 3 小时，1 小时分裂一次。求 n 小时后，容器内有多少细胞？
     * 时间负责度为2的n次方
     *
     * @param n
     *
     * @return
     */
    private static int countCount(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else {
            return countCount(n - 1) * 2 - countCount(n - 3);
        }
    }

}
