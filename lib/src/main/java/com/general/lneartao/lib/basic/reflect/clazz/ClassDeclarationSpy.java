package com.general.lneartao.lib.basic.reflect.clazz;

import com.general.lneartao.lib.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/5/31.
 */
public class ClassDeclarationSpy {
    public static void main(String... args) {
        spy("java.util.concurrent.ConcurrentNavigableMap");
//        spy("[Ljava.lang.String;");
//        spy("java.io.InterruptedIOException");
//        spy("java.security.Identity");
    }

    private static void spy(String arg) {
        try {
            Class<?> c = Class.forName(arg);
            Logger.printl("Class: " + c.getCanonicalName());
            Logger.printl("Modifiers: " + Modifier.toString(c.getModifiers()));

            Logger.printl("Type Parameters:");
            TypeVariable[] tv = c.getTypeParameters();
            if (tv.length != 0) {
                System.out.print("  ");
                for (TypeVariable t : tv) {
                    System.out.printf("%s ", t.getName());
                }
                System.out.println();
            } else {
                Logger.printl("  -- No Type Parameters --");
            }

            Logger.printl("Implemented Interfaces:");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs) {
                    System.out.printf("  %s%n", intf.toString());
                }
                System.out.println();
            } else {
                Logger.printl("  -- No Implemented Interfaces --");
            }

            Logger.printl("Inheritance Path:");
            List<Class> l = new ArrayList<>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l) {
                    System.out.printf("  %s%n", cl.getCanonicalName());
                }
                System.out.println();
            } else {
                Logger.printl("  -- No Super Classes --");
            }

            Logger.printl("Annotations:");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann) {
                    System.out.printf("  %s%n", a.toString());
                }
                System.out.println();
            } else {
                Logger.printl("  -- No Annotations --");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
}
