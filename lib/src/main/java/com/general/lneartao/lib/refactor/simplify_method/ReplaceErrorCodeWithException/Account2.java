package com.general.lneartao.lib.refactor.simplify_method.ReplaceErrorCodeWithException;

/**
 * 抛出受检异常的方式
 *
 * @author lneartao
 * @date 2018/10/19.
 */
public class Account2 {
    private int balance;

    private int withdraw(int amount) {
        try {
            newWithdraw(amount);
            return 0;
        } catch (BalanceException e) {
            return -1;
        }
    }

    private void newWithdraw(int amount) throws BalanceException {
        if (amount > balance) {
            throw new BalanceException();
        }
        balance -= amount;
    }

    public static void main(String[] args) {
        Account2 account = new Account2();
        int amount = 0;
        try {
            account.newWithdraw(amount);
            doTheUsualThing();
        } catch (BalanceException e) {
            handleOverdrawn();
        }
    }

    private static void handleOverdrawn() {

    }

    private static void doTheUsualThing() {

    }
}
