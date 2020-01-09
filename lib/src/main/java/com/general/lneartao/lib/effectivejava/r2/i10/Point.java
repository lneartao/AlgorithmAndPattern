package com.general.lneartao.lib.effectivejava.r2.i10;

import com.google.auto.value.AutoValue;

/**
 * @author lneartao
 * @date 2020/1/9.
 */
@AutoValue
abstract class Point {
    static Point create(int x, int y) {
        return new AutoValue_Point(x, y);
    }

    abstract int x();

    abstract int y();

    public static void main(String[] args) {
        Point x = Point.create(1, 2);
        System.out.println(x);
    }
}
