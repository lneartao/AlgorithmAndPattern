package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class MethodTroubleReturns {
    private void drinkMe(int liters) {
        if (liters < 0) {
            throw new IllegalArgumentException("I can't drink a negative amount of liquid");
        }
    }

    public static void main(String[] args) {
        try {
            MethodTroubleReturns mtr = new MethodTroubleReturns();
            Class<?> c = mtr.getClass();
            Method m = c.getDeclaredMethod("drinkMe", int.class);
            m.invoke(mtr, -1);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            System.out.printf("drinkMe() failed: %s%n", cause.getMessage());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
