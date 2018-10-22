package com.general.lneartao.lib.refactor.generalization.PullUpConstructorBody;

/**
 * 构造函数本体上移：在超类中新建一个构造函数，并在子类构造函数中调用它
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee {

    protected String name;
    protected String id;

    protected Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    void initialize() {
        if (isPriviliged()) {
            assignCar();
        }
    }

    boolean isPriviliged() {
        return false;
    }

    void assignCar() {

    }
}
