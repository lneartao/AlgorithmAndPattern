package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * finally语句块总是在控制权离开try语句块时执行的，无论try语句块是正常结束还是意外结束的。
 * 总之，每一个finally语句块都应该正常结束，除非抛出的是不受检查的异常。
 * 千万不要用一个return、break、continue、或throw来退出一个finally语句块
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P36 {
    public static void main(String[] args) {
        Logger.printl(decision());
    }

    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
