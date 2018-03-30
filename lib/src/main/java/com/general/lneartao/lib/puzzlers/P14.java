package com.general.lneartao.lib.puzzlers;

/**
 * 在字符串和字符串常量中要优先选择的是转义字符序列，而不是Unicode转义字符。
 * 因为Unicode转义字符可能会因为它们在编译序列中被处理得过早而引起混乱
 *
 * @author lneartao
 * @date 2018/3/28.
 */

public class P14 {
    public static void main(String[] args) {
        System.out.println("a\u0022.length()+\u0022b".length());
        System.out.println("a".length() + "b".length());
        System.out.println("a\".length() + \"b".length());
    }
}
