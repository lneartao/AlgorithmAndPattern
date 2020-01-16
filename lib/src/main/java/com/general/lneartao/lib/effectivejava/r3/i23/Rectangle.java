package com.general.lneartao.lib.effectivejava.r3.i23;

/**
 * @author lneartao
 * @date 2020/1/16.
 */
public class Rectangle implements Figure {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
