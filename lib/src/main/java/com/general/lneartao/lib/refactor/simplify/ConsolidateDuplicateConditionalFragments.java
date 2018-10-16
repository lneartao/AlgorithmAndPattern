package com.general.lneartao.lib.refactor.simplify;

/**
 * 合并重复的条件片段：将这段重复代码搬移到条件表达式之外
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class ConsolidateDuplicateConditionalFragments {

    private void doSomething(int price) {
        double total;
        if (isSpecialDeal()) {
            total = price * 0.95;
        } else {
            total = price * 0.98;
        }
        send(total);
    }

    private boolean isSpecialDeal() {
        return true;
    }

    private void send(double amount) {
        // do something else
    }
}
