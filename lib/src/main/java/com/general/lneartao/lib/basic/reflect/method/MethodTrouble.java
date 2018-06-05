package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.Method;

/**
 * 当一个方法是泛型，编译器会用它的upper bound替换它，在这里即Object，因此lookup方法就无法找到
 * Tips: Always pass the upper bound of the parameterized type when searching for a method.
 * @author lneartao
 * @date 2018/6/4.
 */
public class MethodTrouble<T> {
    public void lookup(T t) {

    }

    public void find(Integer i) {

    }

    public static void main(String[] args) {
        spy("lookup", "java.lang.Integer");
        spy("find", "java.lang.Integer");
    }

    private static void spy(String name, String className) {
        try {
            Class cArg = Class.forName(className);
            Class<?> c = (new MethodTrouble<Integer>()).getClass();
            Method m = c.getMethod(name, cArg);
            System.out.printf("Found:%n  %s%n", m.toGenericString());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
