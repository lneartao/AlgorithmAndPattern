package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Employee {
    private EmployeeType type;

    public int getType() {
        return type.getTypeCode();
    }

    private int payAmount() {
        switch (getType()) {
            case EmployeeType.ENGINEER:
                return 1;
            case EmployeeType.SALESMAN:
                return 2;
            case EmployeeType.MANAGER:
                return 3;
            default:
                return 4;
        }
    }
}
