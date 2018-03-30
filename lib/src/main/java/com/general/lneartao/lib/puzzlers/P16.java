package com.general.lneartao.lib.puzzlers;

/**
 * 最好不要使用Unicode转义字符
 * 打印\n换行在不同的平台如UNIX，WINDOWS会有不一样的表现，因此最好使用println
 *
 * @author lneartao
 * @date 2018/3/28.
 */

public class P16 {
    public static void main(String[] args) {
        char c = '\n';
        System.out.println(c);
    }
}
