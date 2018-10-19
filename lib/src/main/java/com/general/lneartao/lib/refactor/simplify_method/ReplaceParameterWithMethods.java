package com.general.lneartao.lib.refactor.simplify_method;

/**
 * 以函数取代参数：让参数接受者去除该项参数，并直接调用前一个函数
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class ReplaceParameterWithMethods {
    private int quantity;
    private int itemPrice;

    public double getPrice() {
        return discountedPrice();
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }

    private int getDiscountLevel() {
        if (quantity > 100) {
            return 2;
        } else {
            return 1;
        }
    }

    private double discountedPrice() {
        if (getDiscountLevel() == 2) {
            return getBasePrice() * 0.1;
        } else {
            return getBasePrice() * 0.05;
        }
    }
}
