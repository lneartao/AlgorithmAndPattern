package com.general.lneartao.lib.refactor.simplify_method.ReplaceConstructorWithFactoryMethod;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Employee {
    private int type;
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    public Employee(int type) {
        this.type = type;
    }
}
