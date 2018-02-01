package com.general.lneartao.lib.designpattern.state;

/**
 * Created by lneartao on 2017/12/4.
 */

public class Mammoth {
    private State state;

    public Mammoth() {
        state = new PeacefulState(this);
    }

    public void timePasses() {
        if (state.getClass().equals(PeacefulState.class)) {
            changeStateTo(new AngryState(this));
        } else {
            changeStateTo(new PeacefulState(this));
        }
    }

    public void changeStateTo(State state) {
        this.state = state;
        state.onEnterState();
    }

    public void observe() {
        state.observe();
    }

    @Override
    public String toString() {
        return "The mammoth";
    }
}
