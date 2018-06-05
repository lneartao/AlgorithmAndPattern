package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;

/**
 * @author lneartao
 * @date 2018/6/1.
 */
public class Deet<T> {
    private boolean testDeet(Locale l) {
        System.out.printf("Locale = %s, ISO Language Code = %s%n", l.getDisplayName(), l.getISO3Language());
        return true;
    }

    private int testFoo(Locale l) {
        return 0;
    }

    private boolean testBar() {
        return true;
    }

    private static void test(String a, String b, String c, String d) {
        try {
            Class<?> clazz = Class.forName(a);
            Object t = clazz.newInstance();
            Method[] allMethods = clazz.getDeclaredMethods();
            for (Method m : allMethods) {
                String mName = m.getName();
                if (!mName.startsWith("test") || (m.getGenericReturnType() != boolean.class)) {
                    continue;
                }
                Type[] pType = m.getGenericParameterTypes();
                if ((pType.length != 1) || Locale.class.isAssignableFrom(pType[0].getClass())) {
                    continue;
                }
                System.out.printf("invoking %s()%n", mName);
                try {
                    m.setAccessible(true);
                    Object o = m.invoke(t, new Locale(b, c, d));
                    System.out.printf("%s() returned %b%n", mName, o);

                    // Handle any exceptions thrown by method to be invoked.
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    System.out.printf("invocation of %s failed: %s%n", mName, cause.getMessage());
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test("com.general.lneartao.lib.basic.reflect.method.Deet", "ja", "JP", "JP");
        test("com.general.lneartao.lib.basic.reflect.method.Deet", "xx", "XX", "XX");
    }

}
