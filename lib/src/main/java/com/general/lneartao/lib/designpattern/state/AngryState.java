package com.general.lneartao.lib.designpattern.state;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/12/4.
 */

public class AngryState implements State {
    private Mammoth mammoth;

    public AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void onEnterState() {
        Logger.printl(mammoth + " is furious!");
    }

    @Override
    public void observe() {
        Logger.printl(mammoth + " gets angry!");
    }
}
