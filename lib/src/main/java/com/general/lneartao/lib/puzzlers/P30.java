package com.general.lneartao.lib.puzzlers;

/**
 * @author lneartao
 * @date 2018/3/30.
 */
public class P30 {
    public static void main(String[] args) {
        infiniteLoop();
    }

    private static void infiniteLoop() {
        String i = "infiniteLoop";
        while (i != i + 0) {
            // 无限循环
        }
    }
}
