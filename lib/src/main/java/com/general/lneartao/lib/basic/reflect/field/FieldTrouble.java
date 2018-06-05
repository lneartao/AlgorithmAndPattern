package com.general.lneartao.lib.basic.reflect.field;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;

/**
 * 反射不支持装箱
 *
 * @author lneartao
 * @date 2018/5/31.
 */
public class FieldTrouble {
    public final Integer val = 0;

    public static void main(String... args) {
        FieldTrouble ft = new FieldTrouble();
        try {
            Class<?> c = ft.getClass();
            Field f = c.getDeclaredField("val");
            f.setAccessible(true);
//            f.setInt(ft, 42);               // IllegalArgumentException
            f.set(ft, new Integer(1222));     // solution
            Logger.printl(ft.val);
            Logger.printl(f.get(ft));
            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
