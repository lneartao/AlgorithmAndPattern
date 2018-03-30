package com.general.lneartao.lib.puzzlers;

/**
 * 任何浮点操作，只要它的一个或多个操作数为NaN，那么其结果是NaN。但是它却具有奇怪的结果
 * 一旦一个计算产生了NaN，它就被损坏了，没有任何跟进一步的计算可以修复这样的损坏。
 *
 * @author lneartao
 * @date 2018/3/30.
 */
public class P29 {
    public static void main(String[] args) {
        double i = Double.NaN;
        System.out.println(i - i == 0);
        double i2 = 0.0 / 0.0;
        System.out.println(i2 - i2 == 0);
//        infiniteLoop();
    }

    private static void infiniteLoop() {
        double i = 0.0 / 0.0;
        double i2 = Double.NaN;
        while (i != i) {
            // 无限循环
        }
    }
}
