package com.general.lneartao.lib.refactor.simplify_method.IntroduceParameterObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class Account {

    public double getFlowBetween(Date start, Date end) {
        double result = 0;
        for (Entry each : entries) {
            if (each.getChargeDate().equals(start) || each.getChargeDate().equals(end)
                    || (each.getChargeDate().after(start) && each.getChargeDate().before(end))) {
                result += each.getValue();
            }
        }
        return result;
    }

    private List<Entry> entries = new ArrayList<>();

    public static void main(String[] args) {
        Date startDate = new Date();
        Date endDate = new Date();
        double flow = new Account().getFlowBetween(startDate, endDate);
    }
}
