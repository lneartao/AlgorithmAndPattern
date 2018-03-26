package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 复合赋值表达式的坑，最好在任何情况下避免使用这种方式赋值
 * 复合赋值表达式的语言规范是 E1 op = E2 等价于 E1 = (T) ((E1)op(E2))，其中T是E1的类型，除非E1只被计算一次
 * 关键的地方在于，复合赋值表达式可能会包含一个隐藏的转型
 *
 * @author lneartao
 * @date 2018/3/26.
 */

public class P9 {
    public static void main(String[] args) {
        short x = 0;
        int i = 123456;
        x += i;
//        x=x+i;
        Logger.printl(x);
    }
}
