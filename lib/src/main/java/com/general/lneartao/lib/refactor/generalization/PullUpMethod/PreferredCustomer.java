package com.general.lneartao.lib.refactor.generalization.PullUpMethod;

import java.util.Date;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class PreferredCustomer extends Customer {

    @Override
    public double chargeFor(Date lastBillDate, Date date) {
        return 1;
    }
}
