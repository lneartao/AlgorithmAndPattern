package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/16.
 */
public class NullCustomer extends Customer {

    @Override
    public String getName() {
        return "occupant";
    }

    @Override
    public BillingPlan getPlan() {
        return BillingPlan.basic();
    }

    @Override
    public PaymentHistory getHistory() {
        return PaymentHistory.newNull();
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
