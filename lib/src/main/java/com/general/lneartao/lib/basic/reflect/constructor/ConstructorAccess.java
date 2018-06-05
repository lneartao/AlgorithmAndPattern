package com.general.lneartao.lib.basic.reflect.constructor;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 修饰符只有public, protected and private和Annotations
 * Modifier里面没有 包级私有 ！！！
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorAccess {
    public static void main(String[] args) {
        access("java.io.File", Modifier.PRIVATE);
    }

    private static void access(String className, int searchMod) {
        try {
            Class<?> c = Class.forName(className);
            Constructor[] allConstructor = c.getDeclaredConstructors();
            for (Constructor ctor : allConstructor) {
                int mods = accessModifiers(ctor.getModifiers());
                if (searchMod == mods) {
                    Logger.printl(ctor.toGenericString());
                    System.out.printf("  [ synthetic=%-5b var_args=%-5b ]%n", ctor.isSynthetic(), ctor.isVarArgs());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int accessModifiers(int m) {
        return m & (Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED);
    }
}
