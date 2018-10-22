package com.general.lneartao.lib.refactor.generalization.PullUpConstructorBody;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Manager extends Employee {

    private int grade;

    public Manager(String name, String id, int grade) {
        super.name = name;
        super.id = id;
        this.grade = grade;
    }
}
