package com.general.lneartao.lib.refactor.generalization.PullUpMethod;

import java.util.Date;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class RegularCustomer extends Customer {

    void createBill(Date date) {
        double chargeAmount = chargeFor(lastBillDate, date);
        addBill(date, chargeAmount);
    }

    private double chargeFor(Date lastBillDate, Date date) {
        return 0;
    }
}
