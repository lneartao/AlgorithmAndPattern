package com.general.lneartao.lib.puzzlers;

/**
 * 三元表达式中不同数据类型的问题
 * 规则有三点：
 * 如果第二个和第三个操作数具有相同的类型，那么它就是条件表达式的类型
 * 如果一个操作数的类型是T，T标识byte、short或char，而另一个操作数是一个int类型的常量表达式，它的值可以用类型T表示的，那么条件表达式的类型就是T
 * 否则，将对操作数类型运用二进制数字提升，而条件表达式的类型就是第二个和第三个操作数被提升之后的类型
 * 下面的例子很好地诠释了这三点
 *
 * @author lneartao
 * @date 2018/3/26.
 */

public class P8 {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);
        System.out.println(x);
    }
}
