package com.general.lneartao.lib.basic.reflect.array;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ArrayFind {

    public static void main(String[] args) {
//        find("java.nio.ByteBuffer");
//        find("java.lang.Throwable");
        find("java.awt.Cursor");
    }

    private static void find(String className) {
        boolean found = false;
        try {
            Class<?> clazz = Class.forName(className);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Class<?> c = field.getType();
                if (c.isArray()) {
                    found = true;
                    System.out.printf("%s%n"
                                    + "           Field: %s%n"
                                    + "            Type: %s%n"
                                    + "  Component Type: %s%n",
                            field, field.getName(), c, c.getComponentType());
                }
            }
            if (!found) {
                Logger.printl("No array field!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
