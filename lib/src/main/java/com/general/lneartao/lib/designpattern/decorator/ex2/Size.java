package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public interface Size {
    public static final int SIZE_SMALL = 1;
    public static final int SIZE_MIDDLE = 2;
    public static final int SIZE_LARGE = 3;

    double getCost();
}
