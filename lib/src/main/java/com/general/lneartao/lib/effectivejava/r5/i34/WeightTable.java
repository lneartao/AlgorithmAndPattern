package com.general.lneartao.lib.effectivejava.r5.i34;

/**
 * @author lneartao
 * @date 2020/1/19.
 */
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = 185;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.getSurfaceWeight(mass));
        }
    }
}
