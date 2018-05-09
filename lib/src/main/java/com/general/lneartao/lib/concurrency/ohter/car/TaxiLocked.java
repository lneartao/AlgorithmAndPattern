package com.general.lneartao.lib.concurrency.ohter.car;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.immutable.Point;

/**
 * 容易发生死锁，不要这么做！
 *
 * @author lneartao
 * @date 2018/5/1.
 */
public class TaxiLocked implements Car {
    @GuardedBy("this")
    private Point location, destination;
    private final Dispatcher dispatcher;

    public TaxiLocked(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    /**
     * 问题在这里，先获得了TaxiLocked的锁，然后又获得了DispatcherLocked的锁
     *
     * @param location
     */
    public synchronized void setLocation(Point location) {
        this.location = location;
        if (location.equals(destination)) {
            dispatcher.notifyAvailable(this);
        }
    }
}
