package com.general.lneartao.lib.refactor.simplify_method.ReplaceErrorCodeWithException;

/**
 * 以异常取代错误码：改用异常
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class Account {

    private int balance;

    private void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Amount too large");
        } else {
            balance -= amount;
        }
    }

    private boolean canWithdraw(int amount) {
        return balance > amount;
    }

    public static void main(String[] args) {
        Account account = new Account();
        int amount = 0;
        if (!account.canWithdraw(amount)) {
            handleOverdrawn();
        } else {
            account.withdraw(amount);
            doTheUsualThing();
        }
    }

    private static void handleOverdrawn() {

    }

    private static void doTheUsualThing() {

    }
}
