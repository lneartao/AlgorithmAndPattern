package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public abstract class EmployeeType {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    abstract int getTypeCode();

    abstract int payAmount();
}
