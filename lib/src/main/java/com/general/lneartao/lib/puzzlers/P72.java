package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * final修饰方法意味着不能被覆写（对实例方法而言）或隐藏（对静态方法而言）
 * final修饰域意味着该域不能被赋值超过一次，然而可以被隐藏
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P72 extends Jeopardy {
    public static final String PRIZE = "2 cents";

    public static void main(String[] args) {
        Logger.printl(P72.PRIZE);
    }
}

class Jeopardy {
    public static final String PRIZE = "&64,000";
}
