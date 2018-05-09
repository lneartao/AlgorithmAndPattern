package com.general.lneartao.lib.concurrency.ohter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 显式地为任务创建线程
 * 问题存在的原因是它没有限制可创建线程的数量：线程生命周期的开销非常高、资源消耗、稳定性
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/28.
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {

    }
}
