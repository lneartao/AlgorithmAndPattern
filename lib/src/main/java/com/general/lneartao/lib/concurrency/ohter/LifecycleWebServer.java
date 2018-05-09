package com.general.lneartao.lib.concurrency.ohter;

import com.general.lneartao.lib.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Web server with shutdown support
 * ExecutorService扩展了Executor，增加了生命周期管理方法
 *
 * @author lneartao
 * @date 2018/4/29.
 */
public class LifecycleWebServer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!exec.isShutdown()) {
            try {
                Socket connection = socket.accept();
                exec.execute(() -> handleRequest(connection));
            } catch (RejectedExecutionException e) {
                // 这个异常是在Executor使用shutdown()后，还在执行一些未完成的任务，这个时候又有任务提交，但是Executor不再接受，就抛出该异常
                if (!exec.isShutdown()) {
                    Logger.printl("task submission rejected");
                }
            }
        }
    }

    private void handleRequest(Socket connection) {
        Request request = readRequest(connection);
        if (isShutdownRequest(request)) {
            stop();
        } else {
            dispatchRequest(request);
        }
    }

    private void stop() {
        exec.shutdown();
    }

    interface Request {

    }

    private Request readRequest(Socket s) {
        return null;
    }

    private void dispatchRequest(Request r) {

    }

    private boolean isShutdownRequest(Request r) {
        return false;
    }
}
