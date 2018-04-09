package com.general.lneartao.lib.puzzlers;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lneartao
 * @date 2018/4/3.
 */
public class P41 {

    /**
     * 这个方法还是存在问题：因为in.close()和out.close()还是会抛出IOException，
     * 那么这个异常就会阻止out.close()被调用，从而使输出流仍保持在开放状态
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    static void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        } finally {
            // wrong one
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }

            methodCorrectOne(in, out);
        }
    }

    /**
     * 这是Java7后的写法
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    static void copyTryWithResource(String src, String dest) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void methodCorrectOne(InputStream in, OutputStream out) {
        closeIgnoringException(in);
        closeIgnoringException(out);
    }

    private static void closeIgnoringException(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {

            }
        }
    }

}
