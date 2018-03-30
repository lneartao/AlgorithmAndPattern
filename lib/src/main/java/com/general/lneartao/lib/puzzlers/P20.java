package com.general.lneartao.lib.puzzlers;

import java.util.regex.Pattern;

/**
 * 注意String.replace和replaceAll的区别，后者的第一个参数是正则表达式
 * 而"."是可以匹配任何单个的字符，因此，类名中的每一个字符都被替换成了一个斜杠
 * 我们可以通过\进行转义，而\又需要一个\进行转义，因此就变成了第三个表达式
 * 而quote是接受一个字符串作为参数，并可以添加必需的转义字符，它将返回一个正则表达式字符串，该字符串将精确匹配输入的字符串
 *
 * @author lneartao
 * @date 2018/3/28.
 */

public class P20 {
    public static void main(String[] args) {
        System.out.println(P20.class.getName().replace(".", "/") + ".class");
        System.out.println(P20.class.getName().replaceAll(".", "/") + ".class");
        System.out.println(P20.class.getName().replaceAll("\\.", "/") + ".class");
        System.out.println(P20.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
    }
}
