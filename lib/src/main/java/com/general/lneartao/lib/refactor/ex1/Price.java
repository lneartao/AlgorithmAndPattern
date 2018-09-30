package com.general.lneartao.lib.refactor.ex1;

/**
 * 运用了State模式
 *
 * @author lneartao
 * @date 2018/9/29.
 */
public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    protected int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
