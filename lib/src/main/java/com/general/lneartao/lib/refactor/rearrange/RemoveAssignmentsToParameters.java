package com.general.lneartao.lib.refactor.rearrange;

/**
 * 移除对参数的赋值：以一个临时变量取代该参数的位置
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class RemoveAssignmentsToParameters {

    int discountUgly(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) {
            inputVal -= 2;
        }
        if (quantity > 100) {
            inputVal -= 1;
        }
        if (yearToDate > 10000) {
            inputVal -= 4;
        }
        return inputVal;
    }

    int discount(final int inputVal, final int quantity, final int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) {
            result -= 2;
        }
        if (quantity > 100) {
            result -= 1;
        }
        if (yearToDate > 10000) {
            result -= 4;
        }
        return result;
    }
}
