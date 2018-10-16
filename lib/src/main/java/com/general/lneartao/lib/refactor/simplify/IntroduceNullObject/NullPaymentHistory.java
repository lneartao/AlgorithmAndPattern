package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/16.
 */
public class NullPaymentHistory extends PaymentHistory {

    @Override
    int getWeeksDelinquentInLastYear() {
        return 0;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
