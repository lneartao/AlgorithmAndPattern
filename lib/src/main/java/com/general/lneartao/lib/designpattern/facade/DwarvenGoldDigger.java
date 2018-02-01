package com.general.lneartao.lib.designpattern.facade;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/17.
 */

public class DwarvenGoldDigger extends DwarvenMineWorker {
    @Override
    public void work() {
        Logger.printl("{" + name() + "} digs for gold.");
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
}
