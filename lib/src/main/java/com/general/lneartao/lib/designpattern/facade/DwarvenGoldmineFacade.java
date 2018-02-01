package com.general.lneartao.lib.designpattern.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lneartao on 2017/11/17.
 */

public class DwarvenGoldmineFacade {
    private final List<DwarvenMineWorker> mWorkers;

    public DwarvenGoldmineFacade() {
        mWorkers = new ArrayList<>();
        mWorkers.add(new DwarvenGoldDigger());
        mWorkers.add(new DwarvenCartOperator());
        mWorkers.add(new DwarvenTunnelDigger());
    }

    public void startNewDay() {
        makeActions(mWorkers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    public void digOutGold() {
        makeActions(mWorkers, DwarvenMineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(mWorkers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(Collection<DwarvenMineWorker> workers, DwarvenMineWorker.Action... actions) {
        for (DwarvenMineWorker worker : workers) {
            worker.action(actions);
        }
    }
}
