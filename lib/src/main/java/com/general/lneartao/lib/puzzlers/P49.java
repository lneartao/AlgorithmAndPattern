package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.Calendar;

/**
 * 这里遇到是类初始化的顺序引起的问题
 * final类型的域只有在其初始化表达式是常量表达式时才是常量，所以CURRENT_YEAR不是常量
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class P49 {
    public static final P49 INSTANCE = new P49();
    private final int beltSize;
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    // 这个也是可以的
//    private static final int CURRENT_YEAR = 2000;

    public P49() {
        beltSize = CURRENT_YEAR - 1930;

        // 下面这个才能得到预期的结果
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        beltSize = currentYear-1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        Logger.printl("Elvis wears a size " + INSTANCE.beltSize() + " belt.");
        // 这运行完后才把CURRENT_YEAR的值初始化成功而不再是0
    }
}
