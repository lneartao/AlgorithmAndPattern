package com.general.lneartao.lib.designpattern.decorator.ex2;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        Logger.printl(beverage.getDescription());
        Beverage be2 = new HouseBlend();
        be2 = new Mocha(be2);
        be2 = new Soy(be2);
        be2.setSize(Size.SIZE_SMALL);
        Logger.printl(be2.getDescription());
    }

}
