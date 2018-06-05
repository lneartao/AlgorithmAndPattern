package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * method modifiers: public, protected, private, static, final, abstract, synchronized, native, strictfp, annotations
 * compareTo的例子：有个参数为Object的重载是编译器生成的桥接方法，目的是为了使Java的泛型方法生成的字节码和1.5版本前的字节码相兼容、
 *
 * @author lneartao
 * @date 2018/6/1.
 */
public class MethodModifierSpy {
    private static int count;

    private static synchronized void inc() {
        count++;
    }

    private static synchronized int cnt() {
        return count;
    }

    private static void spy(String className, String method) {
        try {
            Class<?> c = Class.forName(className);
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                if (!m.getName().equals(method)) {
                    continue;
                }
                System.out.printf("%s%n", m.toGenericString());
                System.out.printf("  Modifiers:  %s%n", Modifier.toString(m.getModifiers()));
                System.out.printf("  [ synthetic=%-5b var_args=%-5b bridge=%-5b ]%n",
                        m.isSynthetic(), m.isVarArgs(), m.isBridge());
                inc();
            }
            System.out.printf("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        spy("java.lang.Object", "wait");
//        spy("java.lang.StrictMath", "toRadians");
//        spy("com.general.lneartao.lib.basic.reflect.method.MethodModifierSpy", "inc");
//        spy("java.lang.Class", "getConstructor");
        spy("java.lang.String", "compareTo");
    }
}
