package com.general.lneartao.lib.concurrency.ohter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 串行执行任务
 *
 * @author lneartao
 * @date 2018/4/28.
 */
public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {

    }
}
