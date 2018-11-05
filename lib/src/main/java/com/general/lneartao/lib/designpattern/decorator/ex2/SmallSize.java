package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class SmallSize implements Size {
    @Override
    public double getCost() {
        return .1;
    }
}
