package com.general.lneartao.lib.refactor.simplify;

import java.util.Date;

/**
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
        if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
            int charge = quantity * winterRate + winterServiceCharge;
        } else {
            int charge = quantity * summerRate;
        }
    }
}
