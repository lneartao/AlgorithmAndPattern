package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 许多VM都将栈的深度限制为1024，因此这里调用的数量是1+2+4+8...+2的1024次方 = 2的1025次方-1,
 * 而抛出的异常是2的1024次方，假设机器可以在每秒执行1010个调用，并产生1010个异常，那么该程序将在大约1.7*10291年后终结
 * 虽然严格意义来说，这不是一个无限循环，但已经可以看成一个无限循环了
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class P45 {
    public static void main(String[] args) {
        workHard();
        Logger.printl("It' s nap time");
    }

    private static void workHard() {
        try {
            workHard();
        } finally {
            workHard();
        }
    }
}
