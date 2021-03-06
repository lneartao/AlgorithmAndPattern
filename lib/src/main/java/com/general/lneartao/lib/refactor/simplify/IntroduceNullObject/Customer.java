package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Customer implements Nullable {

    public String getName() {
        return "";
    }

    public BillingPlan getPlan() {
        return new BillingPlan();
    }

    public PaymentHistory getHistory() {
        return new PaymentHistory();
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public static Customer newNull() {
        return new NullCustomer();
    }
}
