package com.general.lneartao.lib.basic.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2018/6/1.
 */
public class InvokeMain {
    public static void main(String[] args) {
        try {
            Class<?> c = Deet.class;
            Class[] argTypes = new Class[]{String[].class};
            Method main = c.getDeclaredMethod("main", argTypes);
            String[] mainArgs = new String[]{"ja", "JP", "JP"};
            System.out.printf("invoking %s.main() %n", c.getName());
            // 这里要转成Object类型啊~，静态方法的话，第一个参数传null
            main.invoke(null, (Object) mainArgs);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
