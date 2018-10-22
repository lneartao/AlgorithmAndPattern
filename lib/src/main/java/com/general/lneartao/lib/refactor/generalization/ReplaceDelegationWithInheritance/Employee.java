package com.general.lneartao.lib.refactor.generalization.ReplaceDelegationWithInheritance;

/**
 * 以继承取代委托：让委托类继承受托类
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee extends Person {

    @Override
    public String toString() {
        return "Emp: " + getLastName();
    }
}
