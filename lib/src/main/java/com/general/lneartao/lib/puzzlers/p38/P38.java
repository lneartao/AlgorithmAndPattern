package com.general.lneartao.lib.puzzlers.p38;

import com.general.lneartao.lib.Logger;

/**
 * 对空final值进行多次赋值时可能会出现的问题
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P38 {
    public static final long GUEST_USER_ID = -1;
    private static final long USER_ID = getUserIdOrGuest();

    private static long getUserIdOrGuest() {
        try {
            return getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            Logger.printl("logging in as guest");
            return GUEST_USER_ID;
        }
    }


    // 这么写从语义上来说是正确的，但是由于很难编写一个完美的编译期（现在的编译期是保守的，所以它必须拒绝某些可以证明是安全的程序）
    /*static {
        try {
            USER_ID = getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            USER_ID = GUEST_USER_ID;
            Logger.printl("Logging in as guest");
        }
    }*/

    private static long getUserIdFromEnvironment() throws IdUnavailableException {
        throw new IdUnavailableException();
    }
}
