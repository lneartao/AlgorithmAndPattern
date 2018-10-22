package com.general.lneartao.lib.refactor.generalization.ReplaceDelegationWithInheritance;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return name.substring(name.lastIndexOf(' ') + 1);
    }
}
