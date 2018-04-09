package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 这里也有两个问题
 * 1、魔法数
 * 2、%和*的运算顺序是相等的，所以 ms%60*1000等价于(ms%60)*1000而不是ms%(60*1000)
 * 最好的解决办法是不要使用魔法值，用定义常量的方法进行声明初始化
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P35 {
    public static void main(String[] args) {

        int minutes = 0;
        for (int ms = 0; ms < 60 * 60 * 1000; ms++) {
            if (ms % 60 * 1000 == 0) {
                minutes++;
            }
        }
        Logger.printl(minutes);
    }
}
