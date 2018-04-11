package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 如果只想查询线程中断状态，不要使用Thread.interrupted()，因为它会清除当前线程的中断状态，而应该使用Thread.isInterrupted()
 *
 * @author lneartao
 * @date 2018/4/10.
 */
public class P84 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        correctOne();
        wrongOne();
    }

    private static void wrongOne() {
        if (Thread.interrupted()) {
            Logger.printl("Interrupted: " + Thread.interrupted());
        } else {
            Logger.printl("Not interrupted: " + Thread.interrupted());
        }
    }

    private static void correctOne() {
        if (Thread.currentThread().isInterrupted()) {
            Logger.printl("Interrupted: " + Thread.currentThread().isInterrupted());
        } else {
            Logger.printl("Not Interrupted: " + Thread.currentThread().isInterrupted());
        }
    }
}
