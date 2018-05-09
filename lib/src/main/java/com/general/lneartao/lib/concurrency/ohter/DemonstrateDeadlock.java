package com.general.lneartao.lib.concurrency.ohter;

import java.util.Random;

/**
 * Driver loop that induces deadlock under typical conditions
 *
 * @author lneartao
 * @date 2018/5/1.
 */
public class DemonstrateDeadlock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        Random rnd = new Random();
        DynamicOrderDeadlock.Account[] accounts = new DynamicOrderDeadlock.Account[NUM_ACCOUNTS];
        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            accounts[i] = new DynamicOrderDeadlock.Account();
        }
        class TransferThread extends Thread {
            @Override
            public void run() {
                for(int i=0;i<NUM_ITERATIONS;i++){
                    int fromAct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAct = rnd.nextInt(NUM_ACCOUNTS);
                    DynamicOrderDeadlock.DollarAmount amount = new DynamicOrderDeadlock.DollarAmount(rnd.nextInt(1000));
                    try {
                        DynamicOrderDeadlock.transferMoneyBad(accounts[fromAct],accounts[toAct],amount);
                    } catch (DynamicOrderDeadlock.InsufficientFundsException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }
    }
}
