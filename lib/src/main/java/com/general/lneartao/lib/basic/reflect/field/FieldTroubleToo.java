package com.general.lneartao.lib.basic.reflect.field;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;

/**
 * final的原始数据类型和String初始化时是字面量的时候，编译器会进行内联优化，所以在反射的时候如果用一般的方式获取字段，
 * 就会产生没有修改到该字段的假象，但是如果用反射的方式获取该字段，就可以发现已经修改了该字段的值
 * final String str = "xxx"，存储在方法区的常量池中，是常量；final String str = new String("xxx");也存储在方法区中，但是是引用类型
 * 跟FieldAccessor有关~
 * 复杂数据类型如HashMap的反射应该怎么办
 *
 * @author lneartao
 * @date 2018/5/31.
 */
public class FieldTroubleToo {
    public final int a = 100000;
    public int aa = 2;
    public final boolean b = true;
    public final Double c = 1D;
    public final String s1 = "1";
    public final String s2 = new String("2");
    public final String s3 = "3";
    public final String s4 = new String("4");

    public int getA() {
        return a;
    }

    public int getA1() {
        return a + 1;
    }

    public static void main(String... args) {
        FieldTroubleToo ft = new FieldTroubleToo();
        try {
            Class<?> c = ft.getClass();

            Field intA = c.getDeclaredField("a");
            intA.setAccessible(true);
            intA.setInt(ft, 1111);
            Logger.printl("原始的方式： " + ft.a);
            Logger.printl(ft.getA());
            Logger.printl(ft.getA1());
            Logger.printl("反射的方式： " + intA.getInt(ft));

            Field intAA = c.getDeclaredField("aa");
            intAA.setAccessible(true);
            intAA.setInt(ft, 2222);
            Logger.printl(ft.aa);
            Logger.printl(intAA.getInt(ft));


            Field booleanB = c.getDeclaredField("b");
            booleanB.setAccessible(true);
            booleanB.setBoolean(ft, Boolean.FALSE);
            Logger.printl(ft.b);
            Logger.printl(booleanB.getBoolean(ft));

            Field doubleD = c.getDeclaredField("c");
            doubleD.setAccessible(true);
            doubleD.set(ft, new Double(2));
            Logger.printl(ft.c);
            Logger.printl(doubleD.get(ft));

            Field string1 = c.getDeclaredField("s1");
            string1.setAccessible(true);
            string1.set(ft, "100");
            Logger.printl(ft.s1);
            Logger.printl(string1.get(ft));

            Field string2 = c.getDeclaredField("s2");
            string2.setAccessible(true);
            string2.set(ft, new String("200"));
            Logger.printl(ft.s2);
            Logger.printl(string2.get(ft));

            Field string3 = c.getDeclaredField("s3");
            string3.setAccessible(true);
            string3.set(ft, new String("300"));
            Logger.printl(ft.s3);
            Logger.printl(string3.get(ft));

            Field string4 = c.getDeclaredField("s4");
            string4.setAccessible(true);
            string4.set(ft, "400");
            Logger.printl(ft.s4);
            Logger.printl(string4.get(ft));
            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
