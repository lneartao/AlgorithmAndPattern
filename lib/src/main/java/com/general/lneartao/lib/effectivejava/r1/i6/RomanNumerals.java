package com.general.lneartao.lib.effectivejava.r1.i6;

import java.util.regex.Pattern;

/**
 * 避免创建不必要的对象
 * 比如 String s = "hello"; 不应该 String s = new String("hello");
 * 还有注意优先使用基本数据类型而不是装箱基本类型，就是 long 和 Long的区别
 * 该条准则的适用规则一般用于 创建的对象代价非常昂贵，而一般小对象就不必遵循这个规则。
 * 也应该避免维护自己的对象池，除非对象池的实例是数据库连接池，网络连接池等创建昂贵资源。
 *
 * @author lneartao
 * @date 2020/1/7.
 */
public class RomanNumerals {
    public static final String REGEX =
            "^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    private static final Pattern ROMAN = Pattern.compile(REGEX);

    static boolean isRomanNumberal(String s) {
        return ROMAN.matcher(s).matches();
        // 不适用这种写法是因为它每次调用都会在内部创建一个Pattern实例，却只用了一次，之后就可以进行垃圾回收了，而创建Pattern的实例成本很高
//        return s.matches(REGEX);
    }
}
