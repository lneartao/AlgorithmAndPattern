package com.general.lneartao.lib.refactor.simplify.ReplaceConditionalWithPolymorphism;

/**
 * 以多态取代条件表达式：将这个条件表达式的每个分支放进一个子类内的复写函数中，然后将原始函数声明为抽象函数
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class Employee {
    private EmployeeType type;

    public int getType() {
        return type.getTypeCode();
    }

    public int payAmount() {
        return type.payAmount();
    }

}
