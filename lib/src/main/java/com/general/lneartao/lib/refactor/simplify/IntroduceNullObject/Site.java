package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class Site {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    private static void doSomething(Site site) {
        Customer customer = site.getCustomer();
        BillingPlan plan;
        if (customer == null) {
            plan = BillingPlan.basic();
        } else {
            plan = customer.getPlan();
        }

        String customerName;
        if (customer == null) {
            customerName = "occupant";
        } else {
            customerName = customer.getName();
        }

        int weeksDelingquent;
        if (customer == null) {
            weeksDelingquent = 0;
        } else {
            weeksDelingquent = customer.getHistory().getWeeksDelingquentInLastYear();
        }
    }
}
