package com.general.lneartao.lib.basic.reflect.clazz;

/**
 * @author lneartao
 * @date 2018/6/5.
 */
public class ClassTrouble {

    public static void main(String[] args) {
        try {
            Class<?> c = Cls.class;
            c.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class Cls {
    private Cls() {
    }
}
