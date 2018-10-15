package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 自封装字段：为这个字段建立取值、设值函数，并且只以这些函数来访问字段
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class SelfEncapsulateField {
    private int low, high;

    boolean includes1(int arg) {
        return arg >= low && arg <= high;
    }

    boolean includes2(int arg) {
        return arg >= getLow() && arg <= getHigh();
    }

    void grow1(int factor) {
        high = high * factor;
    }

    void grow2(int factor) {
        setHigh(getHigh() * factor);
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
