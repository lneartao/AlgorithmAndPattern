package com.general.lneartao.lib.basic.reflect.enumerated;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Class.getEnumConstants()可以保证返回值的声明顺序，而Class.getFields()和Class.getDeclaredFields()无法保证声明顺序
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class EnumSpy {
    private static final String fmt = " %11s: %s %s%n";

    public static void main(String[] args) {
//        spy("java.lang.annotation.RetentionPolicy");
        spy("java.util.concurrent.TimeUnit");
    }

    private static void spy(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (!clazz.isEnum()) {
                System.out.printf("%s is not an enum type%n", clazz);
                return;
            }
            System.out.printf("Class: %s%n", clazz);

            Field[] fields = clazz.getDeclaredFields();
            List<Field> cst = new ArrayList<>();
            List<Field> mbr = new ArrayList<>();
            for (Field f : fields) {
                if (f.isEnumConstant()) {
                    cst.add(f);
                } else {
                    mbr.add(f);
                }
            }
            if (!cst.isEmpty()) {
                print(cst, "Constant");
            }
            if (!mbr.isEmpty()) {
                print(mbr, "Field");
            }

            Constructor[] ctors = clazz.getDeclaredConstructors();
            for (Constructor ctor : ctors) {
                System.out.printf(fmt, "Constructor", ctor.toGenericString(), synthetic(ctor));
            }

            Method[] mths = clazz.getDeclaredMethods();
            for (Method method : mths) {
                System.out.printf(fmt, "Method", method.toGenericString(), synthetic(method));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void print(List<Field> lst, String s) {
        for (Field f : lst) {
            System.out.printf(fmt, s, f.toGenericString(), synthetic(f));
        }
    }

    private static String synthetic(Member m) {
        return (m.isSynthetic() ? "[ synthetic ]" : "");
    }
}
