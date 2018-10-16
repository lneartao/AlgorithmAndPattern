package com.general.lneartao.lib.refactor.simplify;

import java.util.Date;

/**
 * 分解条件表达式：从if、then、else三个段落中分别提炼出独立函数
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class DecomposeConditional {

    private void doSomething(Date date,
                             Date SUMMER_START,
                             Date SUMMER_END,
                             int quantity,
                             int summerRate,
                             int winterRate,
                             int winterServiceCharge) {

        if (notSummer(date, SUMMER_START, SUMMER_END)) {
            int charge = getWinterCharge(quantity, winterRate, winterServiceCharge);
        } else {
            int charge = getSummerCharge(quantity, summerRate);
        }
    }

    private int getSummerCharge(int quantity, int summerRate) {
        return quantity * summerRate;
    }

    private int getWinterCharge(int quantity, int winterRate, int winterServiceCharge) {
        return quantity * winterRate + winterServiceCharge;
    }

    private boolean notSummer(Date date, Date SUMMER_START, Date SUMMER_END) {
        return date.before(SUMMER_START) || date.after(SUMMER_END);
    }
}
