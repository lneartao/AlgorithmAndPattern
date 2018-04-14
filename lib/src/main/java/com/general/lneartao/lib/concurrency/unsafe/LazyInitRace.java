package com.general.lneartao.lib.concurrency.unsafe;

import com.general.lneartao.lib.concurrency.annotation.NotThreadSafe;

/**
 * Race condition in lazy initialization
 * Don't do that!!!
 *
 * @author lneartao
 * @date 2018/4/12.
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject {
}
