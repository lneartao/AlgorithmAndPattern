package com.general.lneartao.lib.effectivejava.r3.i23;

/**
 * @author lneartao
 * @date 2020/1/16.
 */
public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
