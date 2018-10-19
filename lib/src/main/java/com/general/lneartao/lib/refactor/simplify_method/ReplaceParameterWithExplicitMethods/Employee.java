package com.general.lneartao.lib.refactor.simplify_method.ReplaceParameterWithExplicitMethods;

/**
 * 以明确函数取代参数：针对该参数的每一个可能值，建立一个独立函数
 * @author lneartao
 * @date 2018/10/17.
 */
public class Employee {

    public static Manager createManager() {
        return new Manager();
    }

    public static Salesman createSalesman() {
        return new Salesman();
    }

    public static Engineer createEngineer() {
        return new Engineer();
    }

}
