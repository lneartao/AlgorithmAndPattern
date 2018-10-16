package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class MethodTroubleAgain {
    public static void main(String[] args) {
        AnotherClass ac = new AnotherClass();
        try {
            Class<?> c = ac.getClass();
            Method m = c.getDeclaredMethod("m");
            m.setAccessible(true);  // solution
            Object o = m.invoke(ac);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class AnotherClass {
    private void m() {

    }
}
