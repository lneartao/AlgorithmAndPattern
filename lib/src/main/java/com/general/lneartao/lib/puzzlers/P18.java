package com.general.lneartao.lib.puzzlers;

import java.io.UnsupportedEncodingException;

/**
 * 这个String(byte[])构造器有坑，它的规范描述是
 * 在通过解码使用平台缺省字符集的指定byte数组来构造一个新的String时，该String的长度是字符集的一个函数
 * 因此，它可能不等于byte数组的长度。当给定的所有字节在缺省字符集中并非全部有效时，这个构造器的行为是不确定的。
 *
 * @author lneartao
 * @date 2018/3/28.
 */

public class P18 {
    public static void main(String[] args) {
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) i;
        }
        // 这种写法有问题
//        String str = new String(bytes);

        String str = null;
        try {
            str = new String(bytes, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; str != null && i < str.length(); i++) {
            System.out.println((int) str.charAt(i) + " ");
        }
    }
}
