package com.general.lneartao.lib.refactor.generalization.PullUpConstructorBody;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Manager extends Employee {

    private int grade;

    public Manager(String name, String id, int grade) {
        super(name, id);
        this.grade = grade;
        initialize();
    }

    @Override
    boolean isPriviliged() {
        return grade > 4;
    }
}
