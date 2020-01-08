package com.general.lneartao.lib.effectivejava.r1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * try-with-resources 优先于 try-finally
 * 要使用这个构造的资源，必须先实现AutoCloseable接口，其中包含了单个返回void的close方法。
 *
 * @author lneartao
 * @date 2020/1/8.
 */
public class I9 {
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
