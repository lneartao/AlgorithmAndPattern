package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Manager extends EmployeeType {
    @Override
    int getTypeCode() {
        return EmployeeType.MANAGER;
    }

    @Override
    public int payAmount() {
        return 2;
    }
}
