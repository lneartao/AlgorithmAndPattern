package com.general.lneartao.lib.designpattern.decorator.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public abstract class Beverage {

    Size size;
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public abstract double getSizeCost();

    public void setSize(int size) {
        switch (size) {
            case Size.SIZE_SMALL:
                this.size = new SmallSize();
                break;
            case Size.SIZE_MIDDLE:
                this.size = new MiddleSize();
                break;
            case Size.SIZE_LARGE:
                this.size = new LargeSize();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument");
        }
    }

}
