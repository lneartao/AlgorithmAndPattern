package com.general.lneartao.lib.concurrency.ohter;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Producer-consumer logging service with no shutdown support
 * 优化在LogService
 *
 * @author lneartao
 * @date 2018/4/30.
 * @see LogService
 */
public class LogWriter {
    private static final int CAPACITY = 1000;
    private final BlockingQueue<String> mQueue;
    private final LoggerThread mLoggerThread;

    public LogWriter(Writer writer) {
        mQueue = new LinkedBlockingDeque<>(CAPACITY);
        mLoggerThread = new LoggerThread(writer);
    }

    public void start() {
        mLoggerThread.start();
    }

    public void log(String msg) throws InterruptedException {
        mQueue.put(msg);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter mPrintWriter;

        public LoggerThread(Writer writer) {
            // autoflush
            mPrintWriter = new PrintWriter(writer, true);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    mPrintWriter.println(mQueue.take());
                }
            } catch (InterruptedException e) {
            } finally {
                mPrintWriter.close();
            }
        }
    }
}
