package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 多重转型
 * 从较窄的整数转换成较宽的整型时的符号扩展行为：如果最初的数值类型是有符号的，那么就执行符号扩展；
 * 如果它是char，那么不管它将要被转换成什么类型，都执行零扩展
 * @author lneartao
 * @date 2018/3/26.
 */

public class P6 {
    public static void main(String[] args) {
        Logger.printl((int) (char) (byte) -1);
    }
}
