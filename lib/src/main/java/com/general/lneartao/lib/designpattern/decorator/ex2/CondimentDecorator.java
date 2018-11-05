package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }
}
