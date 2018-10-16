package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * 引入Null对象：将null值替换为null对象
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class Site {
    private Customer customer;

    public Customer getCustomer() {
        return (customer == null) ? Customer.newNull() : customer;
    }

    private static void doSomething(Site site) {
        Customer customer = site.getCustomer();
        BillingPlan plan = customer.getPlan();

        String customerName = customer.getName();

        int weeksDelingquent = customer.getHistory().getWeeksDelinquentInLastYear();
    }
}
