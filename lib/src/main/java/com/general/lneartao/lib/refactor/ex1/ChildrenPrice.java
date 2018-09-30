package com.general.lneartao.lib.refactor.ex1;

/**
 * @author lneartao
 * @date 2018/9/29.
 */
public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
