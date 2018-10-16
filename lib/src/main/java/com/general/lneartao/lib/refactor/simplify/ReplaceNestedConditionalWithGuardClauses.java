package com.general.lneartao.lib.refactor.simplify;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class ReplaceNestedConditionalWithGuardClauses {

    private double getPayAmount(boolean isRetired, boolean isSeparated, boolean isDead) {
        double result;
        if (isDead) {
            result = deadAmount();
        } else {
            if (isSeparated) {
                result = separatedAmount();
            } else {
                if (isRetired) {
                    result = retireAmount();
                } else {
                    result = normalPayAmount();
                }
            }
        }
        return result;
    }

    public double getAdjustedCapital(int ADJ_FACTOR,
                                     int duration,
                                     double income,
                                     int intRate, int capital) {
        double result = 0.0;
        if (capital > 0) {
            if (intRate > 0 && duration > 0) {
                result = income / duration * ADJ_FACTOR;
            }
        }
        return result;
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
