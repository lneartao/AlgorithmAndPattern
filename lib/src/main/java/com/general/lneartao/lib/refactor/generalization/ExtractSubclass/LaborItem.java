package com.general.lneartao.lib.refactor.generalization.ExtractSubclass;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class LaborItem extends JobItem {

    private final Employee employee;

    public LaborItem(int quantity,
                     Employee employee) {
        super(0, quantity);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public boolean isLabor() {
        return true;
    }

    @Override
    public int getUnitPrice() {
        return employee.getRate();
    }
}
