package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.math.BigDecimal;

/**
 * 并不是所有的小数都可以用二进制浮点数来精确表示
 * 所以小数计算都应该使用BigDecimal
 * 而且要注意的一点是必须使用BigDecimal(String)构造器,而不要使用BigDecimal(double)
 *
 * @author lneartao
 * @date 2018/3/26.
 */

public class P2 {
    public static void main(String[] args) {
        Logger.printl(new BigDecimal(.1).toString());
        Logger.printl(new BigDecimal("0.1").toString());
    }
}
