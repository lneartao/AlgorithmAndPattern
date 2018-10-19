package com.general.lneartao.lib.refactor.simplify_method.PreserveWholeObject;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Room {

    private boolean withinPlan(HeatingPlan plan) {
        return plan.withinRange(daysTempRange());
    }

    private TempRange daysTempRange() {
        return new TempRange();
    }
}
