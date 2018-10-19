package com.general.lneartao.lib.refactor.simplify_method.PreserveWholeObject;

/**
 * 保持对象完整：改为传递整个对象
 * @author lneartao
 * @date 2018/10/17.
 */
public class HeatingPlan {
    private TempRange range;

    public boolean withinRange(TempRange tempRange) {
        return range.includes(tempRange);
    }
}
