package com.general.lneartao.lib.concurrency.immutable;

import com.general.lneartao.lib.concurrency.annotation.Immutable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Immutable class built out of mutable underlying objects,
 * demonstration of candidate for lock elision
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<>(3);

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    public String getStoogeNames() {
        List<String> stooges = new Vector<>(3);
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
