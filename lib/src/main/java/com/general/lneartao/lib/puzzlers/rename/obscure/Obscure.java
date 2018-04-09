package com.general.lneartao.lib.puzzlers.rename.obscure;

/**
 * 一个变量可以遮掩具有相同名字的一个类型，只要它们都在同一个范围内：
 * 如果这个名字被用于变量与类型都被许可的范围，那么它将引用到变量上
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class Obscure {
    static String System;

    public static void main(String[] args) {
        // Next line won't compile: System refers to static field
//        System.out.println("hello, obscure world!");
    }
}
