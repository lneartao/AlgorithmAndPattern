package com.general.lneartao.lib.designpattern.state;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/12/4.
 */

public class PeacefulState implements State {
    private Mammoth mammoth;

    public PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void onEnterState() {
        Logger.printl(mammoth + " is calm and peaceful.");
    }

    @Override
    public void observe() {
        Logger.printl(mammoth + " calms down.");
    }
}
