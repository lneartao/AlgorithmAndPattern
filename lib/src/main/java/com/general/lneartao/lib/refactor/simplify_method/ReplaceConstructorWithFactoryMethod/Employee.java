package com.general.lneartao.lib.refactor.simplify_method.ReplaceConstructorWithFactoryMethod;

/**
 * 以工厂函数取代构造函数：将构造函数替换为工厂函数
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class Employee {
    private int type;
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    private Employee(int type) {
        this.type = type;
    }

    public static Employee create(String name) {
        try {
            return (Employee) Class.forName(name).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to instantiate " + name);
        }
    }
}
