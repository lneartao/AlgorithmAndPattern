package com.general.lneartao.lib.effectivejava.r7.i50;

import java.util.Date;

/**
 * 必要时进行保护性拷贝
 *
 * @author lneartao
 * @date 2020/1/21.
 */
public final class PeriodProblem {
    private final Date start;
    private final Date end;

    public PeriodProblem(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
