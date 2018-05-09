package com.general.lneartao.lib.concurrency.ohter;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Encapsulating nonstandard cancellation in a Thread by overriding interrupt
 *
 * @author lneartao
 * @date 2018/4/30.
 * @see SocketUsingTask
 */
public class ReaderThread extends Thread {
    private static final int BUFSZ = 512;
    private final Socket mSocket;
    private final InputStream mInputStream;

    public ReaderThread(Socket socket) throws IOException {
        mSocket = socket;
        mInputStream = socket.getInputStream();
    }

    @Override
    public void interrupt() {
        try {
            mSocket.close();
        } catch (IOException e) {

        } finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[BUFSZ];
            while (true) {
                int count = mInputStream.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            // allow thread to exit
        }
    }

    public void processBuffer(byte[] buf, int count) {
    }
}
