package com.general.lneartao.lib.basic.reflect.enumerated;

import java.lang.reflect.Field;

/**
 * 兼容性问题，可以用X.class.isAssignableFrom(Y.class)来判断
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class EnumTroubleToo {
    public static void main(String[] args) {
        try {
            ETest test = new ETest();
            Field f = test.getClass().getDeclaredField("fld");
            f.setAccessible(true);
            f.set(test, E1.A);

            if (f.getType().isAssignableFrom(E0.class)) {
                // compatible
            } else {
                // expect IllegalArgumentException
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

enum E0 {
    A, B
}

enum E1 {
    A, B
}

class ETest {
    private E0 fld = E0.A;
}
