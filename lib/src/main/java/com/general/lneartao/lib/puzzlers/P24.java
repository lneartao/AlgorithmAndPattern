package com.general.lneartao.lib.puzzlers;

/**
 * 这里有两个问题
 * 1、常量魔法数 0x90
 * 2、byte和int 混合类型的比较
 * 教训：byte数值的符号扩展是产生bug和混乱的一种常见根源
 *
 * @author lneartao
 * @date 2018/3/29.
 */

public class P24 {
    private static final byte TARGET = (byte) 0x90;

    public static void main(String[] args) {

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90) {
                System.out.print("Joy!");
            }
        }
    }
}
