package com.general.lneartao.lib.refactor.simplify_method.PreserveWholeObject;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Room {

    private boolean withinPlan(HeatingPlan plan) {
        int low = daysTempRange().getLow();
        int high = daysTempRange().getHigh();
        return plan.withinRange(low, high);
    }

    private TempRange daysTempRange() {
        return new TempRange();
    }
}
