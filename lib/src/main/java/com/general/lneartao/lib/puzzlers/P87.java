package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 相等的定义是自反性、传递性、对称性
 * 整型和浮点型转换会存在问题，违反了==操作符的传递性
 * 所以要警惕那些混合类型的运算
 *
 * @author lneartao
 * @date 2018/4/10.
 */
public class P87 {
    public static void main(String[] args) {
        long x = Long.MAX_VALUE;
        double y = Long.MAX_VALUE;
        long z = Long.MAX_VALUE - 1;
        // true
        Logger.printl(x == y);
        // true
        Logger.printl(y == z);
        // false
        Logger.printl(x == z);
    }
}
