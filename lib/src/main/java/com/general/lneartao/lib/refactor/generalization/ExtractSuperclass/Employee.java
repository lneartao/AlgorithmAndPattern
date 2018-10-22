package com.general.lneartao.lib.refactor.generalization.ExtractSuperclass;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee extends Party {
    private int annualCost;
    private String id;

    public Employee(String name, int annualCost, String id) {
        super(name);
        this.annualCost = annualCost;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    int getAnnualCost() {
        return annualCost;
    }
}
