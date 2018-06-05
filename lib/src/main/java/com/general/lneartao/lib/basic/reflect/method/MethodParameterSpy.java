package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 1、isImplicit: Returns true if this parameter is implicitly declared in source code.
 * 2、isNamePresent: Returns true if the parameter has a name according to the .class file.
 * 3、isSynthetic: Returns true if this parameter is neither implicitly nor explicitly declared in source code.
 *
 * @author lneartao
 * @date 2018/6/1.
 */
public class MethodParameterSpy {
    private static final String fmt = "%24s: %s%n";

    // for the morbidly curious
    <E extends RuntimeException> void genericThrow() throws E {
    }

    public static void printClassConstructors(Class c) {
        Constructor[] allConstructors = c.getConstructors();
        System.out.printf(fmt, "Number of constructors", allConstructors.length);
        for (Constructor currentConstructor : allConstructors) {
            printConstructor(currentConstructor);
        }
        Constructor[] allDeclConst = c.getDeclaredConstructors();
        System.out.printf(fmt, "Number of declared constructors",
                allDeclConst.length);
        for (Constructor currentDeclConst : allDeclConst) {
            printConstructor(currentDeclConst);
        }
    }

    public static void printClassMethods(Class c) {
        Method[] allMethods = c.getDeclaredMethods();
        System.out.printf(fmt, "Number of methods", allMethods.length);
        for (Method m : allMethods) {
            printMethod(m);
        }
    }

    public static void printConstructor(Constructor c) {
        System.out.printf("%s%n", c.toGenericString());
        Parameter[] params = c.getParameters();
        System.out.printf(fmt, "Number of parameters", params.length);
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }

    public static void printMethod(Method m) {
        System.out.printf("%s%n", m.toGenericString());
        System.out.printf(fmt, "Return type", m.getReturnType());
        System.out.printf(fmt, "Generic return type", m.getGenericReturnType());

        Parameter[] params = m.getParameters();
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }

    public static void printParameter(Parameter p) {
        System.out.printf(fmt, "Parameter class", p.getType());
        System.out.printf(fmt, "Parameter name", p.getName());
        System.out.printf(fmt, "Modifiers", p.getModifiers());
        System.out.printf(fmt, "Is implicit?", p.isImplicit());
        System.out.printf(fmt, "Is name present?", p.isNamePresent());
        System.out.printf(fmt, "Is synthetic?", p.isSynthetic());
    }

    public static void main(String... args) {

        try {
            String className = "com.general.lneartao.lib.basic.reflect.method.ExampleMethods";
            printClassConstructors(Class.forName(className));
            printClassMethods(Class.forName(className));
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}
