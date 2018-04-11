package com.general.lneartao.lib.puzzlers;

/**
 * System.out是带有缓冲的，属于PrintStream，当一个字节数组(byte array)被写入，或者某个println方法被调用，
 * 或者一个换行字符或字节('\n')被写入后，PrintStream类型的flush()就会被自动地调用
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P81 {
    public static void main(String[] args) {
        String greeting = "Hello World";
        // 修正方法一
//        String greeting = "Hello World\n";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.write(greeting.charAt(i));
        }
        // 修正方法二
//        System.out.flush();
    }
}
