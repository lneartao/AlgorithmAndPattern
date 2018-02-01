package com.general.lneartao.lib.designpattern.proxy;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/16.
 */

public class IvoryTower implements WizardTower {
    @Override
    public void enter(Wizard wizard) {
        Logger.printl("{" + wizard + "} enters the tower.");
    }
}
