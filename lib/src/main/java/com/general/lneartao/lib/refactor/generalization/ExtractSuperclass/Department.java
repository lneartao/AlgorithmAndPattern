package com.general.lneartao.lib.refactor.generalization.ExtractSuperclass;

import java.util.Iterator;
import java.util.List;

/**
 * 提炼超类：为这两个雷建立一个超类，将相同特性移至超类
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Department extends Party {
    private List<Employee> staff;

    public Department(String name) {
        super(name);
    }

    @Override
    public int getAnnualCost() {
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

}
