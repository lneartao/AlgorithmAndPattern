package com.general.lneartao.lib.concurrency.ohter.car;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;
import com.general.lneartao.lib.concurrency.immutable.Point;

/**
 * @author lneartao
 * @date 2018/5/1.
 */
@ThreadSafe
public class Taxi implements Car {
    @GuardedBy("this")
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        boolean reachDestination = false;
        synchronized (this) {
            this.location = location;
            reachDestination = location.equals(destination);
        }
        if (reachDestination) {
            dispatcher.notifyAvailable(this);
        }
    }
}
