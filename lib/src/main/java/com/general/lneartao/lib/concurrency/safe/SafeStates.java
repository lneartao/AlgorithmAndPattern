package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lneartao
 * @date 2018/5/8.
 */
@ThreadSafe
public class SafeStates {
    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("alabama", "AL");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
