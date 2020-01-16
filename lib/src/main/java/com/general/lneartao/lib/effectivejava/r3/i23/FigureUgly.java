package com.general.lneartao.lib.effectivejava.r3.i23;

/**
 * @author lneartao
 * @date 2020/1/16.
 */
public class FigureUgly {
    enum Shape {
        RECTANGLE, CIRCLE
    }

    final Shape shape;

    double length;
    double width;

    double radius;

    public FigureUgly(double radius) {
        this.radius = radius;
        shape = Shape.CIRCLE;
    }

    public FigureUgly(double length, double width) {
        this.length = length;
        this.width = width;
        shape = Shape.RECTANGLE;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI * (radius * radius);
            case RECTANGLE:
                return length * width;
            default:
                throw new AssertionError(shape);
        }
    }
}
