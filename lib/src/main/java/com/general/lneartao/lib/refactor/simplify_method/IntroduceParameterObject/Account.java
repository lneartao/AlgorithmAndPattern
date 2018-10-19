package com.general.lneartao.lib.refactor.simplify_method.IntroduceParameterObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 引入参数对象：以一个对象取代这些参数
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class Account {

    public double getFlowBetween(DateRange range) {
        double result = 0;
        for (Entry each : entries) {
            if (range.includes(each.getChargeDate())) {
                result += each.getValue();
            }
        }
        return result;
    }

    private List<Entry> entries = new ArrayList<>();

    public static void main(String[] args) {
        Date startDate = new Date();
        Date endDate = new Date();
        double flow = new Account().getFlowBetween(new DateRange(startDate, endDate));
    }
}
