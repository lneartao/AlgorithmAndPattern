package com.general.lneartao.lib.refactor.generalization.ExtractInterface;


/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class TimeSheet {

    private double charge(Billable employee, int days) {
        int base = employee.getRate() + days;
        if (employee.hasSpecialSkill()) {
            return base * 1.05;
        }
        return base;
    }
}
