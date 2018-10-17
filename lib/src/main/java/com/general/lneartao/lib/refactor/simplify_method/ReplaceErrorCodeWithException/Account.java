package com.general.lneartao.lib.refactor.simplify_method.ReplaceErrorCodeWithException;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Account {

    private int balance;

    int withdraw(int amount) {
        if (amount > balance) {
            return -1;
        } else {
            balance -= amount;
            return 0;
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        int amount = 0;
        if (account.withdraw(amount) == -1) {
            handleOverdrawn();
        } else {
            doTheUsualThing();
        }
    }

    private static void handleOverdrawn() {

    }

    private static void doTheUsualThing() {

    }
}
