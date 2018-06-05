package com.general.lneartao.lib.basic.reflect.field;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * synthetic fields是编译器生成的，比如 this$0是用于内部类 reference the outermost enclosing class
 * field modifiers: public, protected, private, transient, volatile, static, final, annotations
 *
 * @author lneartao
 * @date 2018/5/31.
 */
public class FieldModifierSpy {
    volatile int share;
    int instance;

    class Inner {

    }

    public static void main(String[] args) {
        spy("com.general.lneartao.lib.basic.reflect.field.FieldModifierSpy", Modifier.VOLATILE);
        spy("com.general.lneartao.lib.basic.reflect.field.Spy", Modifier.PUBLIC);
        spy("com.general.lneartao.lib.basic.reflect.field.FieldModifierSpy$Inner", Modifier.FINAL);
        spy("com.general.lneartao.lib.basic.reflect.field.Spy", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL);
    }

    private static void spy(String clazzName, int... args) {
        try {
            Class<?> c = Class.forName(clazzName);
            int searchMods = 0x0;
            for (int arg : args) {
                searchMods |= arg;
            }
            Field[] fields = c.getDeclaredFields();
            Logger.printl("Fields in Class " + c.getName() + " containing modifiers: " + Modifier.toString(searchMods));
            boolean found = false;
            for (Field f : fields) {
                int foundMods = f.getModifiers();
                if ((foundMods & searchMods) == searchMods) {
                    System.out.printf("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n",
                            f.getName(), f.isSynthetic(),
                            f.isEnumConstant());
                    found = true;
                }
            }
            if (!found) {
                Logger.printl("No matching field!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
