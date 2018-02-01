package com.general.lneartao.lib.designpattern.proxy;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/16.
 */

public class WizardTowerProxy implements WizardTower {
    private final WizardTower wizardTower;
    private static final int NUM_WIZARDS_ALLOWED = 3;
    private int numWizards;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard);
            numWizards++;
        } else {
            Logger.printl("{" + wizard + "} is not allowed to enter!");
        }
    }
}
