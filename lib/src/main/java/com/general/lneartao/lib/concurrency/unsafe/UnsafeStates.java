package com.general.lneartao.lib.concurrency.unsafe;

/**
 * Allowing internal mutable state to escape
 * <p>
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/24.
 */
public class UnsafeStates {
    private String[] states = new String[]{
            "Hello", "world"
    };

    public String[] getStates() {
        return states;
    }
}
