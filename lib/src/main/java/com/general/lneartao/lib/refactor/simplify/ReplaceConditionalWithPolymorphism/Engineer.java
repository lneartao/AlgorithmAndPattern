package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Engineer extends EmployeeType{
    @Override
    int getTypeCode() {
        return EmployeeType.ENGINEER;
    }

    @Override
    public int payAmount() {
        return 1;
    }
}
