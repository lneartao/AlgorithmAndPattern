package com.general.lneartao.lib.basic.reflect.array;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class GrowBufferedReader {
    private static final int srcBufSize = 10 * 1024;
    private static char[] src = new char[srcBufSize];

    static {
        src[srcBufSize - 1] = 'x';
    }

    private static CharArrayReader car = new CharArrayReader(src);

    public static void main(String[] args) {
        readAndWrite("grow");
        readAndWrite("");
    }

    private static void readAndWrite(String s) {
        try {
            BufferedReader br = new BufferedReader(car);

            Class<?> c = br.getClass();
            Field f = c.getDeclaredField("cb");

            f.setAccessible(true);
            char[] cbVal = char[].class.cast(f.get(br));

            char[] newVal = Arrays.copyOf(cbVal, cbVal.length * 2);
            if ("grow".equals(s)) {
                f.set(br, newVal);
            }
            for (int i = 0; i < srcBufSize; i++) {
                br.read();
            }
            if (newVal[srcBufSize - 1] == src[srcBufSize - 1]) {
                System.out.printf("Using new backing array, size=%d%n", newVal.length);
            } else {
                System.out.printf("Using original backing array, size=%d%n", cbVal.length);

            }
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }
}
