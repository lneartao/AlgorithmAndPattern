package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Salesman extends EmployeeType {
    @Override
    int getTypeCode() {
        return EmployeeType.SALESMAN;
    }

    @Override
    public int payAmount() {
        return 3;
    }
}
