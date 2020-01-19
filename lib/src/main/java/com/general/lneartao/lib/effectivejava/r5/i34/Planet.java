package com.general.lneartao.lib.effectivejava.r5.i34;

/**
 * 用枚举代替int常量
 * <p>
 * int枚举模式的缺点：不具有类型安全性，几乎没有描述性。
 * 枚举类型的优点：真正的final类，不能扩展，实例受控，单例的泛型化，允许添加任意的方法和域，实现任意的接口， {@link Operation}
 * 提供Object方法，实现Comparable和Serializable接口
 * <p>
 * 特定于常量的方法实现：在枚举类中声明一个抽象的apply方法，并在特定于常量的类主体中，用具体的方法覆盖每个常量的抽象方法 {@link Operation}
 * 枚举策略 {@link PayrollDay}
 * <p>
 * 枚举中的switch语句适合于给外部的枚举类型增加特定于常量的行为。
 * 什么时候使用枚举？
 * 每当需要一组固定常量，并且在编译时就知道其成员的时候，就应该使用枚举。
 * 枚举类型中的常量集并不一定要始终保持不变
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public enum Planet {

    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+34, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    /**
     * F = ma
     *
     * @param mass
     *
     * @return
     */
    public double getSurfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
