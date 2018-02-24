package com.general.lneartao.lib.designpattern.facade;

/**
 * 外观模式
 * 这里分成三个子系统，分别是挖矿、运车、挖通道，而我们只需要跟Facade交流，再由Facade分别和每个子系统交流，我们无需去了解每个子系统的实现细节
 * 其实总而言之，外观模式就是提供一个高层次的接口
 * 在现实中的例子可以参考每个公司的前台～
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
