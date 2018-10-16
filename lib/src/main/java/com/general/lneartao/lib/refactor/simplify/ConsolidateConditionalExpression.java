package com.general.lneartao.lib.refactor.simplify;

/**
 * 合并条件表达式：将这些测试合并为一个条件表达式，并将这个条件表达式提炼成为一个独立函数
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class ConsolidateConditionalExpression {
    private double disabilityAmount(int seniority, int monthsDisabled, boolean isPartTime) {
        if (isNotEligibleForDisability(seniority, monthsDisabled, isPartTime)) {
            return 0;
        }
        // do something else
        return 1;
    }

    private boolean isNotEligibleForDisability(int seniority,
                                               int monthsDisabled,
                                               boolean isPartTime) {
        return (seniority < 2 || monthsDisabled > 12 || isPartTime);
    }

    private double doSomething() {
        return (onVacation() && lengthOfService() > 10) ? 1 : 0.5;
    }

    private boolean onVacation() {
        return true;
    }

    private int lengthOfService() {
        return 1;
    }
}
