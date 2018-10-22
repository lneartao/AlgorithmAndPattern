package com.general.lneartao.lib.refactor.generalization.ExtractSuperclass;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee {
    private String name;
    private int annualCost;
    private String id;

    public Employee(String name, int annualCost, String id) {
        this.name = name;
        this.annualCost = annualCost;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAnnualCost() {
        return annualCost;
    }

    public String getId() {
        return id;
    }
}
