package com.general.lneartao.lib.designpattern.facade;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/17.
 */

public class DwarvenTunnelDigger extends DwarvenMineWorker {
    @Override
    public void work() {
        Logger.printl("{" + name() + "} creates another promising tunnel.");
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
}
