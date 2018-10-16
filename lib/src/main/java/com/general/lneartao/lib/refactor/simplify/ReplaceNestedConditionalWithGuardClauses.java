package com.general.lneartao.lib.refactor.simplify;

/**
 * 以卫语句取代嵌套条件表达式：使用卫语句表现所有特殊情况
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class ReplaceNestedConditionalWithGuardClauses {

    private double getPayAmount(boolean isRetired, boolean isSeparated, boolean isDead) {
        double result;
        if (isDead) {
            return deadAmount();
        }
        if (isSeparated) {
            return separatedAmount();
        }
        if (isRetired) {
            return retireAmount();
        }
        return normalPayAmount();
    }

    public double getAdjustedCapital(int ADJ_FACTOR,
                                     int duration,
                                     double income,
                                     int intRate, int capital) {
        if (capital <= 0 || intRate <= 0 || duration <= 0) {
            return 0.0;
        }
        return income / duration * ADJ_FACTOR;
    }

    private double deadAmount() {
        return 0;
    }

    private double separatedAmount() {
        return 0;
    }

    private double retireAmount() {
        return 0;
    }

    private double normalPayAmount() {
        return 0;
    }

}
