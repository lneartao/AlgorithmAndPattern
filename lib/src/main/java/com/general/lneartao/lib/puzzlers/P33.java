package com.general.lneartao.lib.puzzlers;

/**
 * 原因是，Java使用2的补码的算术运算，它是非对称的。
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P33 {
    public static void main(String[] args) {

//        int i = Integer.MIN_VALUE;
//        long i = Long.MIN_VALUE;
//        short i = Short.MIN_VALUE;
        byte i = Byte.MIN_VALUE;
        while (i != 0 && i == -i) {
            // 无限循环
        }
    }
}
