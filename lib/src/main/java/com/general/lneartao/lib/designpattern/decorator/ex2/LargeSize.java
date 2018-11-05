package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class LargeSize implements Size {
    @Override
    public double getCost() {
        return 0.2;
    }
}
