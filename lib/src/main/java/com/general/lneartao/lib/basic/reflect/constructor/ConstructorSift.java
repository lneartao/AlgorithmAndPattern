package com.general.lneartao.lib.basic.reflect.constructor;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorSift {
    public static void main(String[] args) {
//        sift("java.util.Formatter", "java.util.Locale");
//        sift("java.lang.String", "[C");
//        sift("java.lang.ProcessBuilder", "[Ljava.lang.String;");
        sift("java.util.HashMap", "java.util.Map");
    }

    private static void sift(String className, String classArg) {
        try {
            Class<?> cArg = Class.forName(classArg);
            Class<?> c = Class.forName(className);
            Constructor[] allConstructors = c.getDeclaredConstructors();
            for (Constructor ctor : allConstructors) {
                Class<?>[] pTypes = ctor.getParameterTypes();
                for (int i = 0; i < pTypes.length; i++) {
                    if (pTypes[i].equals(cArg)) {
                        Logger.printl(ctor.toGenericString());

                        Type[] gpTypes = ctor.getGenericParameterTypes();
                        for (int j = 0; j < gpTypes.length; j++) {
                            char ch = gpTypes[j].equals(cArg) ? '*' : ' ';
                            System.out.printf("%7c%s[%d]: %s%n", ch, "GenericParameterType", j, gpTypes[j]);
                        }
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
