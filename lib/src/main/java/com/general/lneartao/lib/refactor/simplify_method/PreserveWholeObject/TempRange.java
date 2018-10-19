package com.general.lneartao.lib.refactor.simplify_method.PreserveWholeObject;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class TempRange {
    private int low;
    private int high;

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public boolean includes(TempRange range) {
        return range.getLow() >= this.getLow() && range.getHigh() <= this.getHigh();
    }
}
