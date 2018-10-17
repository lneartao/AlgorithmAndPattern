package com.general.lneartao.lib.refactor.simplify_method.PreserveWholeObject;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class HeatingPlan {
    private TempRange range;

    public boolean withinRange(int low, int high) {
        return (low >= range.getLow() && high <= range.getHigh());
    }
}
