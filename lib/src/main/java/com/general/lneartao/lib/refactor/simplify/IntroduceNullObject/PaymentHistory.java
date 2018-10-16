package com.general.lneartao.lib.refactor.simplify.IntroduceNullObject;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class PaymentHistory implements Nullable{

    public static NullPaymentHistory newNull() {
        return new NullPaymentHistory();
    }

    int getWeeksDelinquentInLastYear() {
        return 1;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
