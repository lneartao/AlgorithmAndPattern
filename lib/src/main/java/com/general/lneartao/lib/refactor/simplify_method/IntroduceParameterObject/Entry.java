package com.general.lneartao.lib.refactor.simplify_method.IntroduceParameterObject;

import java.util.Date;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Entry {

    private Date chargeDate;
    private double value;

    public Entry(Date chargeDate, double value) {
        this.chargeDate = chargeDate;
        this.value = value;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public double getValue() {
        return value;
    }
}
