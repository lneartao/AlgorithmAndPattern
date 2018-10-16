package com.general.lneartao.lib.refactor.simplify;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class ConsolidateDuplicateConditionalFragments {

    private void doSomething(int price) {
        if (isSpecialDeal()) {
            double total = price * 0.95;
            send(total);
        } else {
            double total = price * 0.98;
            send(total);
        }
    }

    private boolean isSpecialDeal() {
        return true;
    }

    private void send(double amount) {
        // do something else
    }
}
