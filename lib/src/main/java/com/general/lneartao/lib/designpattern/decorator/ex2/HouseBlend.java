package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89 + getSizeCost();
    }

    @Override
    public double getSizeCost() {
        return size.getCost();
    }
}
