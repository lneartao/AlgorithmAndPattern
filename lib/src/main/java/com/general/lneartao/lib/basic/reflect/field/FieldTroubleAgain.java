package com.general.lneartao.lib.basic.reflect.field;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 对于基本类型的静态常量，JAVA在编译时就会把代码中对此常量中引用的地方替换成相应的常量值
 * 静态常量的修改需要用下面例子的这种方式，final量的修改看{@link FieldTroubleToo}
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class FieldTroubleAgain {
    private static final Integer A = 100;
    private static final int b = 100;

    public static void main(String[] args) {
        try {
            Field fieldA = FieldTroubleAgain.class.getDeclaredField("A");
            fieldA.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(fieldA, fieldA.getModifiers() & ~Modifier.FINAL);
            fieldA.set(null, 200);
            Logger.printl(FieldTroubleAgain.A);

            // 修改失败
            Field fieldB = FieldTroubleAgain.class.getDeclaredField("b");
            fieldB.setAccessible(true);
            modifiersField.setInt(fieldB, fieldB.getModifiers() & ~Modifier.FINAL);
            fieldB.setInt(null, 200);
            Logger.printl(FieldTroubleAgain.b);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
