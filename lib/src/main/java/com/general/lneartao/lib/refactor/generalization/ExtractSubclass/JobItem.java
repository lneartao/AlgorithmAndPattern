package com.general.lneartao.lib.refactor.generalization.ExtractSubclass;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class JobItem {

    private int unitPrice;
    private int quantity;

    JobItem(int unitPrice,
            int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return getUnitPrice() * quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isLabor() {
        return false;
    }

}
