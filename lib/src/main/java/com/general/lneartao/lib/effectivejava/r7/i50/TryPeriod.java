package com.general.lneartao.lib.effectivejava.r7.i50;

import java.util.Date;

/**
 * @author lneartao
 * @date 2020/1/21.
 */
public class TryPeriod {
    public static void main(String[] args) {

    }

    private static void fun1() {
        Date start = new Date();
        Date end = new Date();
        PeriodProblem p = new PeriodProblem(start, end);
        end.setYear(78);  // Modifies internals of p!
    }

    private static void fun2() {
        Date start = new Date();
        Date end = new Date();
        PeriodProblem p = new PeriodProblem(start, end);
        p.getEnd().setYear(78);  // Modifies internals of p!
    }
}
