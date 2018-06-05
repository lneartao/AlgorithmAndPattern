package com.general.lneartao.lib.basic.reflect.constructor;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Tips: An important difference between new and Constructor.newInstance() is that new performs method argument
 * type checking, boxing and method resolution. None of these occur in reflection, where explicit choice must be made.
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorTroubleAgain {
    public ConstructorTroubleAgain() {
    }

    public ConstructorTroubleAgain(Integer i) {

    }

    public ConstructorTroubleAgain(Object o) {
        Logger.printl("Constructor passed Object!");
    }

    public ConstructorTroubleAgain(String s) {
        Logger.printl("Constructor passed String!");
    }

    public static void main(String[] args) {
        spy("Object");
    }

    private static void spy(String argType) {
        try {
            Class<?> clazz = ConstructorTroubleAgain.class;
            if ("".equals(argType)) {
                // IllegalArgumentException: wrong number of arguments
                Object o = clazz.getConstructor().newInstance("foo");
            } else if ("int".equals(argType)) {
                // NoSuchMethodException - looking for int, have Integer
                Object o = clazz.getConstructor(int.class);
            } else if ("Object".equals(argType)) {
                // newInstance() does not perform method resolution
                Object o = clazz.getConstructor(Object.class).newInstance("foo");
            } else if ("String".equals(argType)) {
                String s = (String) clazz.getConstructor(String.class).newInstance("foo");
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
