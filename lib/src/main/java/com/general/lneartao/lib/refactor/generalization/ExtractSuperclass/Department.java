package com.general.lneartao.lib.refactor.generalization.ExtractSuperclass;

import java.util.Iterator;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class Department {
    private String name;
    private List<Employee> staff;

    public Department(String name) {
        this.name = name;
    }

    public int getTotalAnnualCost() {
        Iterator<Employee> iterator = getStaff();
        int result = 0;
        while (iterator.hasNext()) {
            Employee each = iterator.next();
            result += each.getAnnualCost();
        }
        return result;
    }

    public int getHeadCount() {
        return staff.size();
    }

    public Iterator<Employee> getStaff() {
        return staff.iterator();
    }

    public void addStaff(Employee employee) {
        staff.add(employee);
    }

    public String getName() {
        return name;
    }
}
