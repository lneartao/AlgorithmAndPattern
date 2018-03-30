package com.general.lneartao.lib.puzzlers;

/**
 * @author lneartao
 * @date 2018/3/30.
 */
public class P28 {
    public static void main(String[] args) {
        infiniteLoop();
    }

    private static void infiniteLoop() {
        int start = Integer.MAX_VALUE - 1;
        for (int i = start; i <= start + 1; i++) {
            // 无限循环
        }

        double i = Double.POSITIVE_INFINITY;
        double i2 = 1.0 / 0.0;
        double i3 = 1.0e40;
        while (i == i + 1) {
            // 无限循环
        }
    }
}
