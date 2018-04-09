package com.general.lneartao.lib.puzzlers.rename.shadow;

import com.general.lneartao.lib.Logger;

/**
 * 一个变量、方法或类型可以分别遮蔽在一个闭合的文本范围内的具有相同名字的所有变量、方法或类型
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class WhoKnows {
    static String sentence = "I don't know.";

    public static void main(String[] args) {
        String sentence = "I know!";
        Logger.printl(sentence);
    }
}

/**
 * 这是一种遮蔽的惯用法
 */
class Belt {
    private final int size;

    public Belt(int size) {
        this.size = size;
    }
}
