package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Process类的叙述：由于某些本地平台只提供有限大小的缓冲，所以如果未能迅速地读取子进程的输出流，就有可能会导致子进程的阻塞，甚至是死锁
 * 教训：为了确保子进程能够结束，你必须排空它的输出流，对于错误流也是一样
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P82 {
    static final String COMMAND = "java BeerBlast slave";

    public static void main(String[] args) throws Exception {
        if (args.length == 1 && args[0].equals("slave")) {
            for (int i = 99; i > 0; i--) {
                Logger.printl(i + " bottles of beer on the wall");
                Logger.printl(i + " bottles of beer");
                Logger.printl("You take on down, pass it around.");
                Logger.printl((i - 1) + " bottles of beer on the wall");
                System.out.println();
            }
        } else {
            Process process = Runtime.getRuntime().exec(COMMAND);
            // 修正
//            drainInBackground(process.getInputStream());
            int exitVal = process.waitFor();
            Logger.printl("exit value = " + exitVal);
        }
    }

    private static void drainInBackground(final InputStream is) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (is.read() >= 0) ;
                } catch (IOException e) {

                }
            }
        }).start();
    }
}
