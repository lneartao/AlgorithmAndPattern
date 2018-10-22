package com.general.lneartao.lib.refactor.generalization.PullUpMethod;

import java.util.Date;

/**
 * 函数上移：将该函数移至超类
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public abstract class Customer {

    private Date lastBillDate;

    private void addBill(Date dat, double amount) {

    }

    void createBill(Date date) {
        double chargeAmount = chargeFor(lastBillDate, date);
        addBill(date, chargeAmount);
    }

    abstract double chargeFor(Date lastBillDate, Date date);
}
