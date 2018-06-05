package com.general.lneartao.lib.basic.reflect.enumerated;

import java.util.Arrays;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class EnumConstants {
    public static void main(String[] args) {
        getEnumConstants("java.lang.annotation.RetentionPolicy");
        getEnumConstants("java.util.concurrent.TimeUnit");
        getEnumConstants();
    }

    private static void getEnumConstants(String... args) {
        try {
            Class<?> c = args.length == 0 ? Eon.class : Class.forName(args[0]);
            System.out.printf("Enum name:  %s%nEnum constants:  %s%n",
                    c.getName(), Arrays.asList(c.getEnumConstants()));
            if (c == Eon.class) {
                System.out.printf("  Eon.values():  %s%n",
                        Arrays.asList(Eon.values()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

enum Eon {
    HADEAN, ARCHAEAN, PROTEROZOIC, PHANEROZOIC
}
