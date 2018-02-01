package com.general.lneartao.lib.designpattern.facade;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/17.
 */

public abstract class DwarvenMineWorker {
    public void goToSleep() {
        Logger.printl("{" + name() + "} goes to sleep.");
    }

    public void wakeUp() {
        Logger.printl("{" + name() + "} wakes up.");
    }

    public void goHome() {
        Logger.printl("{" + name() + "} goes home.");
    }

    public void goToMine() {
        Logger.printl("{" + name() + "} goes to the mine.");
    }

    private void action(Action action) {
        switch (action) {
            case GO_TO_SLEEP:
                goToSleep();
                break;
            case WAKE_UP:
                wakeUp();
                break;
            case GO_HOME:
                goHome();
                break;
            case WORK:
                work();
                break;
            case GO_TO_MINE:
                goToMine();
                break;
            default:
                Logger.printl("Undefined action");
                break;
        }
    }

    public void action(Action... actions) {
        for (Action action : actions) {
            action(action);
        }
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }
}
