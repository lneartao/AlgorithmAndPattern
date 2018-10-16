package com.general.lneartao.lib.refactor.simplify;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class ConsolidateConditionalExpression {
    private double disabilityAmount(int seniority, int monthsDisabled, boolean isPartTime) {
        if (seniority < 2) {
            return 0;
        }
        if (monthsDisabled > 12) {
            return 0;
        }
        if (isPartTime) {
            return 0;
        }

        // do something else
        return 1;
    }

    private double doSomething() {
        if (onVacation()) {
            if (lengthOfService() > 10) {
                return 1;
            }
        }
        return 0.5;
    }

    private boolean onVacation() {
        return true;
    }

    private int lengthOfService() {
        return 1;
    }
}
