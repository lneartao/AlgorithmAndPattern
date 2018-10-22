package com.general.lneartao.lib.refactor.generalization.ReplaceDelegationWithInheritance;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee {

    Person person = new Person();

    public String getName() {
        return person.getName();
    }

    public void setName(String name) {
        person.setName(name);
    }

    @Override
    public String toString() {
        return "Emp: " + person.getLastName();
    }
}
