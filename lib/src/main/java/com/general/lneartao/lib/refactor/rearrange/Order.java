package com.general.lneartao.lib.refactor.rearrange;

/**
 * @author lneartao
 * @date 2018/10/8.
 */
public class Order {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double basePrice() {
        return 10;
    }
}
