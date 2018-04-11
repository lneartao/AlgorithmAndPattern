package com.general.lneartao.lib.puzzlers.p93;

import com.general.lneartao.lib.Logger;

/**
 * 这里举了一个编译器常量关于改变常量值而不经过再次编译直接运行的结果
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class PrintWords {
    public static void main(String[] args) {
        Logger.printl(Words.FIRST + " " + Words.SECOND + " " + Words.THIRD);
    }
}
