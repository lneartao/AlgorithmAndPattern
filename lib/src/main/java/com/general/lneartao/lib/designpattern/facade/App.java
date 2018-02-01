package com.general.lneartao.lib.designpattern.facade;

/**
 * Created by lneartao on 2017/11/17.
 */

public class App {
    public static void main(String[] args) {
        DwarvenGoldmineFacade facade = new DwarvenGoldmineFacade();
        facade.startNewDay();
        facade.digOutGold();
        facade.endDay();
    }
}
