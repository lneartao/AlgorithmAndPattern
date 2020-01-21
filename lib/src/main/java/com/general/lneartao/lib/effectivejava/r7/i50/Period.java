package com.general.lneartao.lib.effectivejava.r7.i50;

import java.util.Date;

/**
 * 必要时进行保护性拷贝
 *
 * Date已经过时了，在Java8后可以使用 {@link java.time.Instant}
 * 为了保护Period实例的内部信息避免受到 {@link TryPeriod#fun1()}的攻击，对于构造器的每个可变参数进行保护性拷贝是有必要的。
 * 注意Period中构建起的有效性检查在拷贝之后，因为这个可以避免在危险阶段期间从另一个线程改变类的参数。危险阶段是指从检查参数开始，直到拷贝参数之间的时间段。
 * 对于参数类型可以被不可信任方子类化的参数，请不要使用clone方法进行保护性拷贝。
 * 为了避免第二种方法攻击，可以修改两个访问方法，让它返回可变内部域的保护性拷贝。
 * @author lneartao
 * @date 2020/1/21.
 */
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}
