package com.general.lneartao.lib.basic.reflect.clazz;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2018/5/31.
 */
public class ClassSpy {
    public static void main(String... args) {
//        spy("java.lang.ClassCastException", ClassMember.CONSTRUCTOR);
//        spy("java.nio.channels.ReadableByteChannel", ClassMember.METHOD);
        spy("com.general.lneartao.lib.basic.reflect.clazz.ClassMember", ClassMember.ALL);
    }


    private static void spy(String clazzname, ClassMember... constructor) {
        try {
            Class<?> c = Class.forName(clazzname);
            System.out.printf("Class:%n  %s%n%n", c.getCanonicalName());

            Package p = c.getPackage();
            System.out.printf("Package:%n  %s%n%n",
                    (p != null ? p.getName() : "-- No Package --"));

            for (ClassMember aConstructor : constructor) {
                switch (aConstructor) {
                    case CONSTRUCTOR:
                        printMembers(c.getConstructors(), "Constructor");
                        break;
                    case FIELD:
                        printMembers(c.getFields(), "Fields");
                        break;
                    case METHOD:
                        printMembers(c.getMethods(), "Methods");
                        break;
                    case CLASS:
                        printClasses(c);
                        break;
                    case ALL:
                        printMembers(c.getConstructors(), "Constuctors");
                        printMembers(c.getFields(), "Fields");
                        printMembers(c.getMethods(), "Methods");
                        printClasses(c);
                        break;
                    default:
                        assert false;
                }
            }

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static void printMembers(Member[] mbrs, String s) {
        System.out.printf("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field) {
                System.out.printf("  %s%n", ((Field) mbr).toGenericString());
            } else if (mbr instanceof Constructor) {
                System.out.printf("  %s%n", ((Constructor) mbr).toGenericString());
            } else if (mbr instanceof Method) {
                System.out.printf("  %s%n", ((Method) mbr).toGenericString());
            }
        }
        if (mbrs.length == 0) {
            System.out.printf("  -- No %s --%n", s);
        }
        System.out.printf("%n");
    }

    private static void printClasses(Class<?> c) {
        Logger.printl("Classes:");
        Class<?>[] clss = c.getClasses();
        for (Class<?> cls : clss) {
            System.out.printf("  %s%n", cls.getCanonicalName());
        }
        if (clss.length == 0) {
            System.out.printf("  -- No member interfaces, classes, or enums --%n");
        }
        System.out.printf("%n");
    }
}
