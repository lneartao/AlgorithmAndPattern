package com.general.lneartao.lib.basic.reflect.array;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建一维数组
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ArrayCreator {
    private static String s = "java.math.BigInteger bi[] = {123, 234, 345}";
    private static Pattern p = Pattern.compile("^\\s*(\\S+)\\s*\\w+\\[\\].*\\{\\s*([^}]+)\\s*\\}");

    public static void main(String[] args) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            String cName = m.group(1);
            String[] cVals = m.group(2).split("[\\s,]+");
            int n = cVals.length;

            try {
                Class<?> clazz = Class.forName(cName);
                Object o = Array.newInstance(clazz, n);
                for (int i = 0; i < n; i++) {
                    String v = cVals[i];
                    Constructor ctor = clazz.getConstructor(String.class);
                    Object val = ctor.newInstance(v);
                    Array.set(o, i, val);
                }
                Object[] oo = (Object[]) o;
                System.out.printf("%s[] = %s%n", cName, Arrays.toString(oo));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
