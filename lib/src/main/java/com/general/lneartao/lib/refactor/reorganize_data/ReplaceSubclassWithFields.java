package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 以字段取代子类：修改这些函数，使它们返回超类中的某个新增字段，然后销毁子类
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class ReplaceSubclassWithFields {
}

class Person2 {
    private final boolean isMale;
    private final char code;

    public Person2(boolean isMale, char code) {
        this.isMale = isMale;
        this.code = code;
    }

    static Person2 createMale() {
        return new Person2(true, 'M');
    }

    static Person2 createFemale() {
        return new Person2(false, 'F');
    }

    public static void main(String[] args) {
        Person2 kent = Person2.createMale();
    }

    boolean isMale() {
        return isMale;
    }

    char getCode() {
        return code;
    }
}
