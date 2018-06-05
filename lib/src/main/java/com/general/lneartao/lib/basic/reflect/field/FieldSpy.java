package com.general.lneartao.lib.basic.reflect.field;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/5/31.
 */
public class FieldSpy<T> {
    public boolean[][] b = {{false, false}, {true, true}};
    public String name = "Alice";
    public List<Integer> list;
    public T val;


    public static void main(String[] args) {
        spy("com.general.lneartao.lib.basic.reflect.field.FieldSpy", "b");
        spy("com.general.lneartao.lib.basic.reflect.field.FieldSpy", "name");
        spy("com.general.lneartao.lib.basic.reflect.field.FieldSpy", "list");
        spy("com.general.lneartao.lib.basic.reflect.field.FieldSpy", "val");
    }

    private static void spy(String clazz, String fieldName) {
        try {
            Class<?> c = Class.forName(clazz);
            Field field = c.getField(fieldName);
            Logger.printl("Type; " + field.getType());
            Logger.printl("GenericType: " + field.getGenericType());
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
