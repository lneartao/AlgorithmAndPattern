package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;
import com.general.lneartao.lib.concurrency.unsafe.MutablePoint;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个存在一个可能的性能问题：频繁的复制集合数据
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        return locations.getOrDefault(id, null);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint mutablePoint = locations.get(id);
        if (mutablePoint == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        mutablePoint.x = x;
        mutablePoint.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>(m.size());
        for (String id : result.keySet()) {
            result.put(id, result.get(id));
        }
        return Collections.unmodifiableMap(result);
    }
}
