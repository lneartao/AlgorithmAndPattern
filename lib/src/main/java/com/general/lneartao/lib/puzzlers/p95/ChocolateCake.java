package com.general.lneartao.lib.puzzlers.p95;

import com.general.lneartao.lib.Logger;

/**
 * 操作符的优先级不匹配～
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class ChocolateCake {
    public static void main(String[] args) {
        Logger.printl(true ? false : true == true ? false : true);
    }
}
