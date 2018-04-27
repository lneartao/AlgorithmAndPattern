package com.general.lneartao.lib.concurrency.immutable;

import com.general.lneartao.lib.concurrency.annotation.Immutable;

/**
 * @author lneartao
 * @date 2018/4/24.
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
