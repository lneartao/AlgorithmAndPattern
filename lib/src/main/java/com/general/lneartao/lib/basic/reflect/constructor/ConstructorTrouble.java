package com.general.lneartao.lib.basic.reflect.constructor;

/**
 * 自定义构造函数阻碍了编译器自动生成无参构造函数造成的异常
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConstructorTrouble {
    private ConstructorTrouble(int i) {

    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = ConstructorTrouble.class;
//            Class<?> clazz = Class.forName("com.general.lneartao.lib.basic.reflect.constructor.ConstructorTrouble");
            Object o = clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
