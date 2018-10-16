package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Customer {

    public String getName() {
        return "";
    }

    public BillingPlan getPlan() {
        return new BillingPlan();
    }

    public PaymentHistory getHistory() {
        return new PaymentHistory();
    }
}
