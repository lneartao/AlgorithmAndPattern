package com.general.lneartao.lib.refactor.simplify_method.IntroduceParameterObject;

import java.util.Date;

/**
 * @author lneartao
 * @date 2018/10/19.
 */
public class DateRange {

    private final Date start;
    private final Date end;

    public DateRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public final boolean includes(Date date) {
        return date.equals(start) || date.equals(end) || (date.after(start) && date.before(end));
    }
}
