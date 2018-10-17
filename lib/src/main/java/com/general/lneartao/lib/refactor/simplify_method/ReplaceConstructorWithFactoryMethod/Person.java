package com.general.lneartao.lib.refactor.simplify_method.ReplaceConstructorWithFactoryMethod;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Person {

    static Person createMale() {
        return new Male();
    }

    static Person createFemale() {
        return new Female();
    }
}
