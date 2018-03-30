package com.general.lneartao.lib.puzzlers;

import java.io.File;
import java.util.regex.Matcher;

/**
 * replaceAll比较多坑，所以尽量使用replace，这个方法匹配的是字面常量，是Java5.0之后引入的
 *
 * @author lneartao
 * @date 2018/3/29.
 */

public class P21 {
    public static void main(String[] args) {
//        System.out.println(P21.class.getName().replaceAll("\\.", File.separator) + ".class");
        System.out.println(P21.class.getName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + ".class");
        System.out.println(P21.class.getName().replace(".", File.separator) + ".class");
    }
}
