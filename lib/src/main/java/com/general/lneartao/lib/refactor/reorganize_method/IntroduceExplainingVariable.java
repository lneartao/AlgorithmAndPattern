package com.general.lneartao.lib.refactor.reorganize_method;

/**
 * 引入解释性变量：将该复杂表达式（或其中一部分）的结果放进一个临时变量，以此变量名称来解释表达式用途
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class IntroduceExplainingVariable {
    int mQuantity;
    int mItemPrice;

    double priceUgly() {
        return mQuantity * mItemPrice -
                Math.max(0, mQuantity - 500) * mItemPrice * 0.05 +
                Math.min(mQuantity * mItemPrice * 0.1, 100);
    }

    double price() {
        final int basePrice = mQuantity * mItemPrice;
        final double quantityDiscount = Math.max(0, mQuantity - 500) * mItemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + shipping;
    }

    double price2() {
        return basePrice() - getQuantityDiscount() + getShipping();
    }

    private double getShipping() {
        return Math.min(basePrice() * 0.1, 100);
    }

    private double getQuantityDiscount() {
        return Math.max(0, mQuantity - 500) * mItemPrice * 0.05;
    }

    private int basePrice() {
        return mQuantity * mItemPrice;
    }
}
