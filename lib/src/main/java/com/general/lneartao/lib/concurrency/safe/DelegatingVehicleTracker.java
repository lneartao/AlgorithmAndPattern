package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;
import com.general.lneartao.lib.concurrency.immutable.Point;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Delegating thread safety to a ConcurrentHashMap
 * 将保证线程安全的任务委托给ConcurrentHashMap和不变对象，而不用在每个方法里面使用同步或锁
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }


    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    /**
     * 如果Point不是不变对象的话，这里就会发布了一个指向可变状态的引用，那么就会造成线程不安全
     *
     * @return
     */
    public Point getLocation(String id) {
        return locations.getOrDefault(id, null);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
    }

    // Alternate version of getLocations
    public Map<String, Point> getLocationsAsStatic() {
        return Collections.unmodifiableMap(locations);
    }
}
