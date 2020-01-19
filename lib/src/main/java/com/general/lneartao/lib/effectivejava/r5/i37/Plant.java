package com.general.lneartao.lib.effectivejava.r5.i37;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用EnumMap代替序数索引
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class Plant {
    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    final String name;
    final LifeCycle cycle;

    public Plant(String name, LifeCycle cycle) {
        this.name = name;
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        uglyMethod(new ArrayList<>());
        prettyMethod(new ArrayList<>());
    }

    private static void prettyMethod(List<Plant> garden) {
        Map<LifeCycle, Set<Plant>> cycleSetMap = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            cycleSetMap.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            cycleSetMap.get(p.cycle).add(p);
        }
        System.out.println(cycleSetMap);
    }

    private static void uglyMethod(List<Plant> garden) {
        Set<Plant>[] plants = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < plants.length; i++) {
            plants[i] = new HashSet<>();
        }
        for (Plant p : garden) {
            plants[p.cycle.ordinal()].add(p);
        }
        for (int i = 0; i < plants.length; i++) {
            // 输出
        }
    }
}
