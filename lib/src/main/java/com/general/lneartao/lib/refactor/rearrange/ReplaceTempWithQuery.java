package com.general.lneartao.lib.refactor.rearrange;

/**
 * 以查询取代临时变量：将这个表达式提炼到一个独立函数中。将这个临时变量的所有引用点替换为对新函数的调用。此后，新函数就可被其他函数调用。
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class ReplaceTempWithQuery {

    int mQuantity;
    int mItemPrice;

    double getPriceUgly() {
        int basePrice = mQuantity * mItemPrice;
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }

    double getPrice() {
        return getBasePrice() * getDiscountFactor();
    }

    private double getDiscountFactor() {
        if (getBasePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }

    private int getBasePrice() {
        return mQuantity * mItemPrice;
    }
}
