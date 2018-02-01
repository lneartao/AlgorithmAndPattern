package com.general.lneartao.lib.designpattern.facade;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/17.
 */

public class DwarvenCartOperator extends DwarvenMineWorker {
    @Override
    public void work() {
        Logger.printl("{" + name() + "} moves gold chunks out of the mine.");
    }

    @Override
    public String name() {
        return "Dwarf cart operator";
    }
}
