package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 *
 * @author lneartao
 * @date 2018/5/14.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
//        oom();
        equal();
    }

    private static void oom() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     * 1.6会得到2个false
     * 1.6的intern()会把首次遇到的字符串复制到永久代中，而StringBuilder创建的实例串在Java堆上，所有必然不是同一个引用
     * 1.7后会得到true和false
     * 1.7的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用
     */
    private static void equal() {
        String str1 = new StringBuilder("计算器").append("软件").toString();
        Logger.printl(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        Logger.printl(str2.intern() == str2);
    }
}
