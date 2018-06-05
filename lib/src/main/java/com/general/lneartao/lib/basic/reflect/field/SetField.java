package com.general.lneartao.lib.basic.reflect.field;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 有点缺陷：
 * 1、set方法只支持原始数据类型和对象
 * 2、get方法取array的话只能取到array的引用地址,然后通过String[].class.cast()这个方法转换成String[]
 *
 * @author lneartao
 * @date 2018/5/31.
 */

public class SetField {
    public long chapter = 0;
    public String[] characters = {"Alice", "White Rabbit"};
    public Tweedle twin = Tweedle.DEE;

    public static void main(String[] args) {
        SetField setField = new SetField();
        String fmt = "%6S:  %-12s = %s%n";
        try {
            Class<?> c = setField.getClass();
            Field chap = c.getDeclaredField("chapter");
            System.out.printf(fmt, "before", "chapters", setField.chapter);
            chap.setLong(setField, 12);
            System.out.printf(fmt, "after", "chapters", chap.getLong(setField));

            Field chars = c.getDeclaredField("characters");
            System.out.printf(fmt, "before", "characters", Arrays.asList(setField.characters));
//            String[] resiult = String[].class.cast(chars.get(setField));
//            Logger.printl(resiult);
            String[] newChars = {"Queen", "King"};
            chars.set(setField, newChars);
            System.out.printf(fmt, "after", "characters", Arrays.asList(setField.characters));

            Field t = c.getDeclaredField("twin");
            System.out.printf(fmt, "before", "twin", setField.twin);
            t.set(setField, Tweedle.DUM);
            System.out.printf(fmt, "after", "twin", t.get(setField));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

enum Tweedle {
    DEE, DUM
}