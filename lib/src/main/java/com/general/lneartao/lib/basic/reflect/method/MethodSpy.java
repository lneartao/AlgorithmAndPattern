package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 会漏掉final类型诶，看cast的例子
 *
 * @author lneartao
 * @date 2018/6/1.
 */
public class MethodSpy {
    private static final String fmt = "%24s: %s%n";

    /**
     * for the morbidly curious
     *
     * @param <E>
     * @throws E
     */
    <E extends RuntimeException> void genericThrow() throws E {
    }

    public static void main(String... args) {
        spy("java.lang.Class", "getConstructor");
        spy("java.lang.Class", "cast");
        spy("java.io.PrintStream", "format");
    }

    private static void spy(String name, String method) {
        try {
            Class<?> c = Class.forName(name);
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                if (!m.getName().equals(method)) {
                    continue;
                }
                System.out.printf("%s%n", m.toGenericString());

                System.out.printf(fmt, "ReturnType", m.getReturnType());
                System.out.printf(fmt, "GenericReturnType", m.getGenericReturnType());

                Class<?>[] pType = m.getParameterTypes();
                Type[] gpType = m.getGenericParameterTypes();
                for (int i = 0; i < pType.length; i++) {
                    System.out.printf(fmt, "ParameterType", pType[i]);
                    System.out.printf(fmt, "GenericParameterType", gpType[i]);
                }

                Class<?>[] xType = m.getExceptionTypes();
                Type[] gxType = m.getGenericExceptionTypes();
                for (int i = 0; i < xType.length; i++) {
                    System.out.printf(fmt, "ExceptionType", xType[i]);
                    System.out.printf(fmt, "GenericExceptionType", gxType[i]);
                }
                System.out.println();
            }

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}
