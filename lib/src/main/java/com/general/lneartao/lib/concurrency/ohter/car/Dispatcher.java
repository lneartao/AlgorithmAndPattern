package com.general.lneartao.lib.concurrency.ohter.car;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lneartao
 * @date 2018/5/1.
 */
public class Dispatcher {
    @GuardedBy("this")
    private final Set<Car> taxis;
    @GuardedBy("this")
    private final Set<Car> avaiableTaxis;

    public Dispatcher() {
        taxis = new HashSet<>();
        avaiableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Car car) {
        avaiableTaxis.add(car);
    }

}
